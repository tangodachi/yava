package com.tangodachi.yava

import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import com.tangodachi.yava.interactor.RequestSignInCode
import com.tangodachi.yava.utils.GenerateCode
import com.tangodachi.yava.utils.GenerateCodeMock
import com.tangodachi.yava.utils.SendEmail
import com.tangodachi.yava.utils.SendEmailMock
import com.tangodachi.yava.utils.mockConfiguration
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.MockProvider
import org.koin.test.mock.declare
import org.koin.test.mock.declareMock
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RequestSignInCodeTest : KoinTest {
    private val generateCode = GenerateCodeMock()
    private val sendEmail = SendEmailMock()
    private val requestSignInCode by inject<RequestSignInCode>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(AppModule().module)
    }

    @Before
    fun setup() {
        MockProvider.register { clazz ->
            when (clazz) {
                GenerateCode::class -> generateCode
                SendEmail::class -> sendEmail
                else -> throw IllegalArgumentException("Unknown class: $clazz")
            }
        }
        declareMock<GenerateCode> { generateCode }
        declareMock<SendEmail> { sendEmail }
        declare<Configuration> { mockConfiguration() }
    }

    @Test
    fun `expect send sign in code 1`() = runTest {
        val expected = "AAAABBBB"
        val parameters = RequestSignInCodeParameters(email = "q@q.be")

        generateCode.code = expected
        requestSignInCode(parameters = parameters)

        assertTrue(sendEmail.invoked)
        assertEquals(expected = sendEmail.message, actual = expected)
    }

    @Test
    fun `expect send sign in code 2`() = runTest {
        val expected = "1234EFGH"
        val parameters = RequestSignInCodeParameters(email = "q@q.be")

        generateCode.code = expected
        requestSignInCode(parameters = parameters)

        assertTrue(sendEmail.invoked)
        assertEquals(expected = sendEmail.message, actual = expected)
    }

    @Test
    fun `expect send sign in code with email 2`() = runTest {
        val expected = "john.doe@email.org"
        val parameters = RequestSignInCodeParameters(email = expected)

        generateCode.code = String()
        requestSignInCode(parameters = parameters)

        assertEquals(expected = sendEmail.recipient, actual = expected)
    }

    @Test
    fun `expect send sign in code from sender 1`() = runTest {
        val expected = "q@q.be"
        val parameters = RequestSignInCodeParameters(email = String())

        declare<Configuration> { mockConfiguration(notificationEmail = expected) }
        generateCode.code = String()

        requestSignInCode(parameters = parameters)

        assertEquals(expected = expected, actual = sendEmail.sender)
    }
}