# Mesa Virtual Multisistema (VTT)

Una mesa virtual (VTT) ligera, potente y multiplataforma diseñada para juegos de rol (RPG), desde sistemas populares como D&D y Pathfinder hasta productos independientes especializados. Desarrollada con un enfoque en el alto rendimiento, la propiedad total de los datos y una amplia compatibilidad con diversos dispositivos.

--

## 🚀 Descripción general y visión del proyecto

El objetivo de esta VTT es conectar los entornos de escritorio de alta gama con los dispositivos móviles de gama baja. El software está diseñado para funcionar sin problemas en todo el espectro de hardware:

* **Dispositivos móviles objetivo**: Optimizado para funcionar a la perfección en dispositivos Android de gama baja (smartphones y tablets de menos de 200 €), así como en dispositivos Apple iOS/iPadOS de gama alta.
* **Ecosistemas de escritorio**: Compatibilidad nativa completa con Windows, macOS y Linux (cualquier distribución).

### 🛠️ Tecnologías utilizadas

* **Lenguaje y framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform para una interfaz de usuario y lógica de negocio 100% compartidas entre dispositivos móviles y de escritorio.
* **Almacenamiento local**: SQLDelight para una gestión de bases de datos integradas multiplataforma, rápida y con tipado seguro.
* **Entorno de desarrollo**: JetBrains Suite (IntelliJ IDEA + DataGrip).

--

## 🔒 Política de privacidad, seguridad de datos y monetización

Este software se basa en los principios fundamentales de privacidad del usuario, propiedad total de los datos y transparencia absoluta:

* **Arquitectura 100% local y sin conexión**: El sistema funciona completamente sin conexión. Todos los datos, compendios, campañas y fichas de personaje se guardan exclusivamente en una base de datos local segura en su dispositivo físico.
* **Sin sincronización en la nube ni seguimiento por terceros**: El software no sube sus datos personales a ningún servidor externo, ni distribuye ni vende su información a terceros.
* **Aviso de autenticación**: Los datos personales se utilizan únicamente para generar el inicio de sesión de su perfil local (correo electrónico y contraseña). Dado que no existe una base de datos centralizada en la nube, **perder su contraseña o correo electrónico registrado implica perder el acceso a su cuenta y datos locales de forma permanente**. No existe una función de servidor para restablecer la contraseña.
* **Sin anuncios, telemetría ni software innecesario**: El código fuente es público y accesible para cualquier persona en GitHub para garantizar la ausencia total de adware, software innecesario, scripts de seguimiento, telemetría oculta o publicidad engañosa.
* **Sin microtransacciones**: El software no incluye microtransacciones, compras dentro de la aplicación, muros de pago ni mecánicas de juego desbloqueables de pago de ningún tipo.

---

## 🏗️ Pantallas y Roles del Juego

#### 🔐 Autenticación

* Pantalla de inicio de sesión universal para sesiones de campaña locales.

#### 👑 Pantalla del Dungeon Master (DM)

* **Compendio Universal**: Un navegador de documentación integrado y ultrarrápido que carga los manuales de forma adaptativa según el sistema de juego activo.
* **Gestión de Manuales**: Compatible con el almacenamiento local de manuales, con lectura de datos directamente desde el almacenamiento interno, unidades USB externas o tarjetas MicroSD.
* **Panel de Campaña**: Resumen de la campaña, lanzador de dados digital, hojas de PNJ y creadores de objetos personalizados que insertan contenido en la base de datos sin modificar la base de datos de reglas maestras.
* **Centro de Aprobación**: Centro de notificaciones en tiempo real para aprobar o rechazar las modificaciones de las hojas de personaje solicitadas por los jugadores.

#### ⚔️ Pantalla del Jugador

* **Hoja de Personaje Interactiva**: Hojas de personaje totalmente interactivas y editables con un lanzador de dados integrado.
* **Acceso a reglas específicas**: Acceso directo a los manuales del juego, filtrados exclusivamente para las mecánicas que afectan al jugador (Habilidades, Hechizos, Dotes, Condiciones de estado, Razas y Clases).
* **Motor de sincronización y alertas**: Cualquier cambio estructural en la hoja de personaje activa automáticamente una alerta para el DM, que debe ser aprobada antes de hacerse permanente.

--

## 📄 Licencia

Este proyecto está protegido y licenciado bajo la **Licencia Estricta PolyForm 1.0.0**.

### ⚠️ Solo uso no comercial y restringido

* **Permitido**: Puedes usar este software libremente para pasatiempos personales, investigación académica, estudio o campañas sin fines de lucro.
* **Prohibido**: No puedes usar este software ni su código fuente con fines comerciales, monetización ni dentro de una empresa.
* **Prohibido**: La modificación y redistribución de este código por terceros están **estrictamente prohibidas**. Solo el autor original posee los derechos de distribución y modificación.

Para obtener información legal completa, consulte el archivo oficial [LICENSE.md](./LICENSE.md) en el directorio raíz.

### 🌐 Localizaciones de la licencia

Para ayudar a los desarrolladores de todo el mundo a comprender estas restricciones, se ofrecen traducciones de cortesía en la carpeta [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italian)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Inglés (Reference Copy)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Francés (French)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spanish)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (alemán)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (chino)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (chino)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japonés)](<./Localization/License/LICENSE.ja.md>)
* ...y [muchos otros idiomas](./LICENSE.md).

*Nota: La versión oficial en inglés, ubicada en el directorio raíz, es el único texto legalmente vinculante.*
