# BrickBreaker

A mouse-aimed 2D arcade game built with **Java, Swing, and AWT** as an individual university course project by [Benyamin Karimizadeh](https://github.com/BenyKarimi).

Aim and launch balls to break descending bricks, collect power-ups, and build your score. Game results and the highest score are saved locally and can be reviewed from the main menu.

## Features

- **Ball and brick gameplay:** aiming, ball trajectories, wall rebounds, collision handling, and bricks with different durability.
- **Difficulty selection:** Easy, Medium, and Hard modes, with a player name and customizable ball color.
- **Special bricks and items:** earthquake and dancing-light effects, additional balls, speed and damage boosts, dizziness, brick movement, and health items.
- **Game history:** records the date, player name, elapsed time, and score; displays saved results in a Swing table.
- **High-score tracking:** preserves the highest score between application sessions.
- **Desktop controls:** pause/resume, optional aim guidance, background music, and a setting to enable or disable result saving.

## Implementation

The project uses Java collections, enums, Swing timers, event listeners, Java2D rendering, and buffered text-file I/O. It has no external Java library dependencies.

| Component | Responsibility |
| --- | --- |
| `GameApplication/` | Application entry point and main window. |
| `Model/` | Ball, brick, and collectible-item state, plus brick and item enums. |
| `Panels/GamePanel.java` | Gameplay updates, aiming, movement, collisions, scoring, and rendering. |
| `Panels/` | Menus, game setup, settings, history, and the game-over screen. |
| `FileManagment/FileManager.java` | Reads and writes saved game records and the highest score. |
| `Helper/` | Random generation and table-rendering helpers. |
| `SoundManagment/` | Background audio playback. |

### Local persistence

When **Save** is enabled in Settings, finishing a game writes its result to local text files:

| File | Contents |
| --- | --- |
| `src/FileManagment/GameHistory.txt` | One game per line: `yyyy/MM/dd&&username&&mm:ss&&score`. |
| `src/FileManagment/HighestScore.txt` | The highest score as a single integer. |

The history screen loads these records into a `JTable`. File operations handle `IOException`; persistence uses local files rather than a database. Keep `HighestScore.txt` initialized to a valid integer, such as `0`.

## Getting started

### Requirements

- **JDK 17 or newer**; the included IntelliJ IDEA configuration uses JDK 21.
- A graphical desktop session. Audio playback uses the Java Sound API and an available audio device.
- The included `Imported things/` asset folder and `src/FileManagment/` data files.

Run the application from the **repository root**. Fonts, images, audio, and saved-game files are accessed through relative paths. The data-file directory must be writable to save results.

### Run from PowerShell

Clone the repository:

```powershell
git clone https://github.com/BenyKarimi/BrickBreaker_Project.git
cd BrickBreaker_Project
```

Compile the Java sources:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
$sources = Get-ChildItem src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d out $sources
```

Launch the game from the same directory:

```powershell
java -cp out GameApplication.BrickBreakerGame
```

### Run in IntelliJ IDEA

1. Open the repository folder as a project.
2. Select JDK 21, or another JDK version 17 or newer, as the project SDK.
3. Mark `src/` as the Sources Root if it is not detected automatically.
4. Run `GameApplication.BrickBreakerGame.main()` with the working directory set to the repository root.

## How to play

1. Select **Start new Game** from the main menu.
2. Choose a difficulty, optionally change the ball color, enter your player name, and click **Submit**.
3. Click **Start Game**.
4. Move the mouse to aim and click in the play area to launch the balls when aiming is available.
5. Break bricks and collect items while managing the descending rows. Use **Pause** and **Resume** during play.
6. After the game, choose **Restart** to play again or return to the menu. Open **Show History** to review saved results.

Settings provide separate toggles for aim guidance, music, and saving game results.

## Project layout

```text
BrickBreaker_Project/
|-- Imported things/       # Images, animations, font, and background music
|-- src/
|   |-- FileManagment/     # File I/O, game history, and highest score
|   |-- GameApplication/   # Main class and window
|   |-- Helper/            # Random generation and rendering helpers
|   |-- Model/             # Ball, brick, and item models
|   |-- Panels/            # Gameplay and other Swing screens
|   `-- SoundManagment/    # Audio playback
`-- README.md
```

Package and folder names above match the source code, including the existing `Managment` spelling.

## Troubleshooting

- **`javac` is not recognized:** install a JDK and add its `bin` directory to `PATH`. A JRE alone cannot compile the project.
- **Missing images, font, or music:** restore the `Imported things/` directory and check that the working directory is the repository root. Keep its filenames unchanged.
- **Results are not saved:** enable **Save** in Settings and make sure `src/FileManagment/` is writable.
- **Invalid highest-score value:** `HighestScore.txt` must contain an integer. For a fresh start, use `0`; an empty or malformed file cannot be parsed.

## Author

**Benyamin Karimizadeh** - individual course project.
