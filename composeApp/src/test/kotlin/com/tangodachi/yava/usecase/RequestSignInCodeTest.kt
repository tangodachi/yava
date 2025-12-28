package com.tangodachi.yava.usecase

import com.tangodachi.yava.AppModule
import com.tangodachi.yava.authentication.Authentication
import com.tangodachi.yava.authentication.AuthenticationMock
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.MockProvider
import org.koin.test.mock.declareMock
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RequestSignInCodeTest : KoinTest {
    private val authentication = AuthenticationMock()
    private val requestSignInCode by inject<RequestSignInCode>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(AppModule().module)
    }


    @Before
    fun setup() {
        MockProvider.register { clazz ->
            when (clazz) {
                Authentication::class -> authentication
                else -> throw IllegalArgumentException("Unknown class: $clazz")
            }
        }
        declareMock<Authentication> { authentication }
    }

    @Test
    fun expectRequestSignInCode() = runTest {
        val expectedEmail = "q@q.be"

        requestSignInCode(expectedEmail)

        assertTrue(authentication.requestSignInCode)
        assertEquals(expectedEmail, authentication.email)
    }

    @Test
    fun `expect requestSignCode with email2`() = runTest {
        val expectedEmail = "w@w.be"

        requestSignInCode(expectedEmail)

        assertTrue(authentication.requestSignInCode)
        assertEquals(expectedEmail, authentication.email)
    }
}