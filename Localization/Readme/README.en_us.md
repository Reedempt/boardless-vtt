# Multi-System VTT (Virtual Tabletop)

A lightweight, powerful, and multi-platform Virtual Tabletop (VTT) designed for role-playing games (RPGs) ranging from mainstream systems like D&D and Pathfinder to niche indie products. Built with a focus on high performance, complete data ownership, and extreme hardware accessibility.

---

## 🚀 Project Overview & Vision

The goal of this VTT is to bridge the gap between high-end desktop environments and budget mobile devices. The software is engineered to run smoothly across the entire hardware spectrum:

* **Target Mobile Range**: Optimized to run flawlessly on low-end Android devices (smartphones and tablets under €200), as well as premium Apple iOS/iPadOS hardware.
* **Desktop Ecosystems**: Full native support for Windows, macOS, and Linux (any distribution).

### 🛠️ Tech Stack

* **Language & Framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform for 100% shared UI and business logic across mobile and desktop.
* **Local Storage**: SQLDelight for fast, type-safe, multiplatform embedded database management.
* **Development Environment**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Privacy, Data Security & Monetization Policy

This software is built around the core principles of user privacy, full data ownership, and absolute transparency:

* **100% Offline & Local Architecture**: The system operates entirely offline. All data, compendiums, campaigns, and character sheets are saved exclusively inside a secure local database on your physical device. 
* **Zero Cloud Sync & No Third-Party Tracking**: The software does not upload your personal data to any external server, nor does it distribute or sell your information to third parties.
* **Authentication Notice**: Personal data is used solely to generate your local profile login (email and password). Because there is no centralized cloud database, **losing your password or registered email means losing access to your local account and data permanently**. There is no "reset password" server function.
* **No Ads, Telemetry or Bloatware**: The source code is public and viewable by anyone on GitHub to guarantee the complete absence of adware, bloatware, tracking scripts, hidden telemetry, or misleading advertising.
* **No Microtransactions**: The software features no microtransactions, in-app purchases, paywalls, or paid unlockable game mechanics of any kind. 

---

## 🏗️ Game Screens & Roles

#### 🔐 Authentication

* Universal Login Screen for local campaign sessions.

#### 👑 Dungeon Master (DM) Screen

* **Universal Compendium**: An integrated, ultra-fast documentation browser adaptively loading manuals depending on the active game system.
* **Manual Management**: Support for local manual storage, reading data directly from internal storage, external USB drives, or MicroSD cards.
* **Campaign Dashboard**: Campaign overview, digital Dice Roller, NPC Sheets, and custom item creators that inject content into the database without altering the master rule database.
* **Approval Center**: Real-time notification hub to approve or deny character sheet modifications requested by players.

#### ⚔️ Player Screen

* **Interactive Character Sheet**: Fully interactive, editable character sheets with a built-in Dice Roller.
* **Targeted Rules Access**: Direct access to game manuals filtered strictly for player-facing mechanics (Abilities, Spells, Feats, Status Conditions, Races, and Classes).
* **Sync & Alert Engine**: Any structural change made to the character sheet automatically triggers an alert to the DM, pending approval before becoming permanent.

---

## 📄 License

This project is protected and licensed under the **PolyForm Strict License 1.0.0**.

### ⚠️ Non-Commercial & Restricted Use Only
* **Allowed**: You can use this software freely for personal hobbies, academic research, study, or non-profit campaigns.
* **Prohibited**: You **cannot** use this software or its source code for any commercial purposes, monetization, or within a company.
* **Prohibited**: Third-party modification and redistribution of this code are **strictly forbidden**. Only the original author holds distribution and modification rights.

For full legal details, please read the official [LICENSE.md](./LICENSE.md) file in the root directory.

### 🌐 License Localizations

To help developers around the world understand these restrictions, courtesy translations are available in the [<./Localization/License/>](<./Localization/License/>) folder:

* 🇮🇹 [Italiano (Italian)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Reference Copy)](<./Localization/License/LICENSE.en_us.md>)
* 🇫🇷 [Français (French)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spanish)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (German)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (Chinese)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (Chinese)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (Japanese)](<./Localization/License/LICENSE.ja.md>)
* ...and [many other languages](./LICENSE.md).

*Note: The official English version in the root directory is the only legally binding text.*

---
