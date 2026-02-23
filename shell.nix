{
  pkgs ? import <nixpkgs> { },
}:
pkgs.mkShell rec {
  strictDeps = true;

  nativeBuildInputs = with pkgs; [
    pkg-config
  ];

  buildInputs = with pkgs; [
  lspci
    flite
    glfw
    libGL
    libGLU
    mesa
    libX11
    libXext
    libXcursor
    libXrandr
    libXxf86vm
    libXi
    wayland
    wayland-protocols
    libxkbcommon
    openal
    alsa-lib
    udev
    libpulseaudio
  ];

  LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath buildInputs;

  JAVA_OPTS = "-Dorg.lwjgl.glfw.libname=${pkgs.glfw}/lib/libglfw.so";
}