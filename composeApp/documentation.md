```mermaid
classDiagram
direction TB
	namespace usecase {
        class RequestSignInCode {
	        +invoke(email: String)
        }

        class ValidateSignInCode {
	        +invoke(email: String, code: String)
        }

	}
	namespace authentication {
        class AuthenticationImplementation {
        }

        class RemoteAuthenticationSource {
        }

        class Authentication {
	        requestSignInCode(email: String)
	        validateSignInCode(email: String, code: String)
        }

        class AuthenticationSource {
	        requestSignInCode(email: String)
	        validateSignInCode(email: String, code: String)
        }

	}

	<<Interface>> Authentication
	<<Interface>> AuthenticationSource

    RequestSignInCode --> Authentication
    ValidateSignInCode --> Authentication
    AuthenticationImplementation ..|> Authentication
    AuthenticationImplementation --> AuthenticationSource
    RemoteAuthenticationSource ..|> AuthenticationSource
```