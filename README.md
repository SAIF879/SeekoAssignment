# Seekho Assigment  📺  
A sleek and modern Android application that lets users browse and explore popular anime series, view detailed information, and watch trailers. Built with Kotlin, Jetpack Compose, and Clean Architecture principles for a scalable and maintainable codebase.

---

## 🌟 Features  

### Anime List Page  
- Displays a list of popular/top-rated anime fetched from the [Jikan API](https://jikan.moe/).  
- Each anime item includes:  
  - **Title**  
  - **Number of Episodes**  
  - **Rating** (e.g., MyAnimeList score)  
  - **Poster Image**  

### Anime Detail Page  
- Provides detailed information about the selected anime, including:  
  - **Title**  
  - **Plot/Synopsis**  
  - **Genres**  
  - **Main Cast**  
  - **Number of Episodes**  
  - **Rating**  
  - **Trailer Playback**: Plays the trailer if available, or displays the poster image as a fallback.  

---

## 🚀 Tech Stack  

- **Kotlin**: Modern programming language for concise and expressive code.  
- **Jetpack Compose**: Android's modern UI toolkit for building declarative and responsive UIs.  
- **Retrofit**: A powerful and flexible library for making HTTP API calls.  
- **Dagger Hilt**: Dependency injection for modular and testable code.  
- **MVVM**: Ensures separation of concerns for robust UI interactions.  
- **Clean Architecture**: Provides a clear structure for scalable and maintainable codebases.  

---

## 🛠️ API Usage  

### Anime List  
- **Endpoint**: `https://api.jikan.moe/v4/top/anime`  
- Retrieves a list of popular/top-rated anime series.  

### Anime Details  
- **Endpoint**: `https://api.jikan.moe/v4/anime/{anime_id}`  
- Fetches detailed information about a specific anime, including trailer data.  

---

## 📂 Project Structure  

This project adheres to **MVVM with Clean Architecture**, ensuring a clear separation of concerns.  

### Layers and Modules  

#### **Presentation Layer**  
- Contains UI components built using Jetpack Compose.  
- Includes ViewModels that handle UI state and actions.  

#### **Domain Layer**  
- Encapsulates business logic and use cases.  
- Acts as an intermediary between the Presentation and Data layers.  

#### **Data Layer**  
- Handles data operations (API calls, caching, etc.) using Retrofit.  
- Contains repositories and their implementations.  

### Architecture Overview  

```plaintext  
├── Presentation  
│   ├── ui (Jetpack Compose screens)  
│   ├── usecase (Business logic)
│   ├── viewmodel (ViewModels) 
│  
├── Domain  
│   ├── model (Entities and domain-specific data)  

│  
├── Data  
│   ├── repository (Abstract repositories)  
│   ├── repository_impl (Repository implementations)  
│   ├── network (API services and Retrofit setup)  
