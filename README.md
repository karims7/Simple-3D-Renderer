# 3D Renderer

A 3D renderer built from scratch in plain Java with zero external libraries.

## What Is This?

A program that takes a 3D shape — something that exists in an imaginary
world with X, Y, Z coordinates — and draws it on your flat 2D screen.

Your screen is flat. It has no depth. The whole job of a 3D renderer is
to figure out: "if this thing existed in real 3D space, what would it
look like from where I'm standing?" and then draw that.

## Why Java? Why From Scratch?

Most people think 3D rendering requires insane math and huge libraries.
It doesn't. You can build a basic one in ~200 lines of plain Java.
No dependencies. Fits in 50kb. And you actually understand every line.

## What This Covers

- **Orthographic projection** — go from 3D to 2D by dropping the Z coordinate
- **Triangle rasterization** — figure out which pixels each triangle occupies
- **Z-buffering** — when triangles overlap, draw the one that is in front
- **Flat shading** — simulate light so the shape actually looks 3D

## Project Structure

3DRenderer/
├── DemoViewer.java — main class, entry point, builds the window
├── Vertex.java — a single point in 3D space (x, y, z)
├── Triangle.java — three vertices + a color = one triangular face
└── README.md — this file

## How to Run

Make sure Java is installed:

```bash
java --version
```

Compile and run:

```bash
javac *.java
java DemoViewer
```

A window will pop up — black background, two sliders. That is your renderer.
