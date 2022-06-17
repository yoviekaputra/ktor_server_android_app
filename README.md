This app is android app implementing ktor server on android for access from Local Network.
Ktor server engine using Netty, cause this project create HTTP Server app.

Tech Stack
1. Ktor Server as server provider
2. Clean Architecture
3. Jetpack Compose as ui builder
4. Work Manager as background worker for server wrapper on background
5. Android Hilt as dependency injection

Architecture
I was inspired by Netflix in [a link](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749) article,
There talking about Hexagonal Architecture, so this is the result of my experiment in ktor server implementation.
But, this approach is more of a Clean Architecture, like that.
<img src="/previews/preview5.png" width="80%">


Preview
1. App as Server
<img src="/previews/preview4.jpg" width="80%">
2. Client
<img src="/previews/preview1.png" width="80%">
<img src="/previews/preview2.png" width="80%">
<img src="/previews/preview3.png" width="80%">
