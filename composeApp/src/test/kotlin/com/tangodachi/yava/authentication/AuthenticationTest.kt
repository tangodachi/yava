package com.tangodachi.yava.authentication

import com.tangodachi.yava.AppModule
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

class AuthenticationTest : KoinTest {
    private val authenticationSource = AuthenticationSourceMock()
    private val authentication: Authentication by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(AppModule().module)
    }


    @Before
    fun setup() {
        MockProvider.register { clazz ->
            when (clazz) {
                AuthenticationSource::class -> authenticationSource
                else -> throw IllegalArgumentException("Unknown class: $clazz")
            }
        }
        declareMock<AuthenticationSource> { authenticationSource }
    }

    @Test
    fun `expect source requestSignInCode on requestSignInCode`() = runTest {
        val expectedEmail = "q@q.be"

        authentication.requestSignInCode(expectedEmail)

        assertTrue(authenticationSource.requestSignInCode)
        assertEquals(expectedEmail, authenticationSource.email)
    }

    @Test
    fun `expect source requestSignInCode on requestSignInCode with email 2`() = runTest  {
        val expectedEmail = "e@e.be"

        authentication.requestSignInCode(expectedEmail)

        assertTrue(authenticationSource.requestSignInCode)
        assertEquals(expectedEmail, authenticationSource.email)
    }

    @Test
    fun `expect source validateSignInCode on validateSignInCode`() = runTest {
        val expectedEmail = "q@q.be"
        val expectedCode = "123456"

        authentication.validateSignInCode(expectedEmail, expectedCode)

        assertTrue(authenticationSource.validateSignInCode)
        assertEquals(expectedEmail, authenticationSource.email)
        assertEquals(expectedCode, authenticationSource.code)
    }
}