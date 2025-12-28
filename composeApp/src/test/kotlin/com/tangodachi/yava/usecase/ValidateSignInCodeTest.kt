package com.tangodachi.yava.usecase

import com.tangodachi.yava.AppModule
import com.tangodachi.yava.authentication.Authentication
import com.tangodachi.yava.authentication.AuthenticationMock
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.MockProvider
import org.koin.test.mock.declareMock
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ValidateSignInCodeTest : KoinTest {
    private val authentication = AuthenticationMock()
    private val validateSignInCode by inject<ValidateSignInCode>()

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
    fun `expect validateSignInCode invoked`() = runTest {
        val expectedEmail = "q@q.be"
        val expectedCode = "123456"

        validateSignInCode(expectedEmail, expectedCode)

        assertTrue(authentication.validateSignInCode)
        assertEquals(expectedEmail, authentication.email)
        assertEquals(expectedCode, authentication.code)
    }

    @Test
    fun `expect validateSignInCode with email 2`() = runTest {
        val expectedEmail = "a@q.com"
        val expectedCode = "123456"

        validateSignInCode(expectedEmail, expectedCode)

        assertTrue(authentication.validateSignInCode)
        assertEquals(expectedEmail, authentication.email)
        assertEquals(expectedCode, authentication.code)
    }
}