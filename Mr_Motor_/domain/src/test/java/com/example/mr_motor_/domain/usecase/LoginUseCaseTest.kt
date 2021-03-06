package com.example.mr_motor_.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.mr_motor_.domain.repository.UserRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(23), manifest = "src/main/AndroidManifest.xml", packageName = "com.example.mr_motor_")
class LoginUseCaseTest {
    private val userRepository = mock<UserRepository>()
    private lateinit var resultLiveMutable : MutableLiveData<Boolean>

    @Before
    fun doBefore(){
        resultLiveMutable = MutableLiveData<Boolean>()
        Mockito.`when`(userRepository.login(email = "email@gmail.com", password = "abcABC1234!-=", resultLiveMutable = resultLiveMutable)).then {
            changeResult(true)
        }
    }

    @Test
    fun emailShouldNotBeValid(){
        val useCase = LoginUseCase(userRepository = userRepository)
        useCase.execute(email = "abc", password = "abcABC1234!-=", resultLiveMutable = resultLiveMutable)
        val expected = false
        Assert.assertEquals(expected, resultLiveMutable.value)
    }

    @Test
    fun passwordShouldNotBeValid(){
        val useCase = LoginUseCase(userRepository = userRepository)
        useCase.execute(email = "email@gmail.com", password = "123", resultLiveMutable = resultLiveMutable)
        val expected = false
        Assert.assertEquals(expected, resultLiveMutable.value)
    }

    @Test
    fun shouldLogin(){
        val useCase = LoginUseCase(userRepository = userRepository)
        useCase.execute(email = "email@gmail.com", password = "abcABC1234!-=", resultLiveMutable = resultLiveMutable)
        val expected = true
        Assert.assertEquals(expected, resultLiveMutable.value)
    }

    private fun changeResult(bool : Boolean){
        resultLiveMutable.value = bool
    }
}