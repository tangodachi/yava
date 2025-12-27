```mermaid
classDiagram
direction TB
	namespace usecase {
        class RequestSignInCode {
	        +invoke(email: String)
        }

	}
	namespace authentication {
        class Authentication {
	        requestSignInCode(email: String)
        }

        class AuthenticationImplementation {
        }

        class AuthenticationSource {
	        requestSignInCode(email: String)
        }

        class RemoteAuthenticationSource {
        }

	}

	<<Interface>> Authentication
	<<Interface>> AuthenticationSource

    RequestSignInCode --> Authentication
    AuthenticationImplementation ..|> Authentication
    AuthenticationImplementation --> AuthenticationSource
    RemoteAuthenticationSource ..|> AuthenticationSource
```