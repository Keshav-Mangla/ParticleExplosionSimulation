# 🎆 Particle Explosion App

An interactive Java Swing project that simulates colorful particle explosions when you click anywhere on the screen. Each explosion consists of multiple particles that move outward with realistic gravity and fade away over time.


## 🛠️ Built With

- **Java**
- **Swing GUI Toolkit**
- **Object-Oriented Programming**
- **Basic Physics Simulation (Gravity, Velocity, Lifespan)**

## 🎮 Features

- 💥 Particle explosion at mouse click
- 🎨 Random vibrant colors (HSB-based)
- 🌀 Smooth animation (~60 FPS)
- 🌌 Gravity effect and natural fade-out
- 🖥️ Lightweight & responsive GUI (800x600 window)

## 📸 Screenshot

![ExplosionApp png](https://github.com/user-attachments/assets/082d3ead-6ecc-49d5-919c-d97b05f6f258)

## 📁 Project Structure
particle-explosion-app/
├── ExplosionApp.java        <-- Main Java code (GUI + Particle logic)
├── README.md                <-- Yeh file jo tum bana rahe ho
├── assets/                  <-- (Optional) Folder for images/screenshots/GIFs
│   └── screenshot.png       <-- Screenshot of your app


## 🧠 How It Works

- The app uses a `JPanel` for drawing.
- A `Timer` updates the positions of all particles every ~16ms.
- Each `Particle` object:
  - Has random velocity, color, and lifespan.
  - Is affected by gravity.
  - Fades over time before disappearing.

## 🎯 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Keshav_Mangla/particle-explosion-app.git
   cd particle-explosion-app

javac ExplosionApp.java
java ExplosionApp



