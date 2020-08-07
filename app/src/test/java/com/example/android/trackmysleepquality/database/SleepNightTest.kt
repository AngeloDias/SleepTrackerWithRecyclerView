package com.example.android.trackmysleepquality.database

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SleepNightTest {
    @MockK
    private lateinit var sleepDatabaseMockK: SleepDatabase

    @RelaxedMockK
    private lateinit var sleepNightRelaxedMockK: SleepNight

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun sleepDatabaseTest() {
        val sleepNight = SleepNight(9, 5, 7, 17)

        every { sleepDatabaseMockK.sleepDatabaseDao.get(9) } returns sleepNight

        val result = sleepDatabaseMockK.sleepDatabaseDao.get(9)

        verify { sleepDatabaseMockK.sleepDatabaseDao.get(9) }
        assertEquals(sleepNight, result)

        // using spy from here
        val sleepDatabaseSpy = spyk<SleepDatabase>()
        val sleepNightReturns = SleepNight(1, 8, 18, 3)

        every { sleepDatabaseSpy.sleepDatabaseDao.get(any()) } returns sleepNightReturns

        val sleepNightResult = sleepDatabaseSpy.sleepDatabaseDao.get(8)

        assertEquals(sleepNightReturns, sleepNightResult)

        // capturing parameters
        val slot = slot<Long>()
        every{ sleepDatabaseMockK.sleepDatabaseDao.get(capture(slot)) } returns sleepNight

        val paramValue = 7L

        sleepDatabaseMockK.sleepDatabaseDao.get(paramValue)

        assertEquals(paramValue, slot.captured)
    }

    @Test
    fun sleepNightTest() {
        val sleepNight = mockk<SleepNight>()
        val sleepQualityRating = 9

        every {sleepNight.sleepQuality} returns sleepQualityRating
        assertEquals(sleepQualityRating, sleepNight.sleepQuality)

        verify {sleepNight.sleepQuality}
        assertEquals(sleepQualityRating, sleepNight.sleepQuality)

        assertEquals(0, sleepNightRelaxedMockK.sleepQuality)
        assertEquals(0, sleepNightRelaxedMockK.nightId)
        assertEquals(0, sleepNightRelaxedMockK.endTimeMilli)
        assertEquals(0, sleepNightRelaxedMockK.startTimeMilli)

        //using mockkClass
        val sleepNightClassMocked = mockkClass(SleepNight::class)
        val expected = 3L

        every { sleepNightClassMocked.nightId } returns expected

        assertEquals(expected, sleepNightClassMocked.nightId)

        verify { sleepNightClassMocked.nightId }
    }

}
