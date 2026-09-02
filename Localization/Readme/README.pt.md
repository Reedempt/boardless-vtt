# Mesa Virtual Multiplataforma (VTT)

Uma mesa virtual (VTT) leve, poderosa e multiplataforma, concebida para jogos de RPG, desde sistemas populares como D&D e Pathfinder até produtos indie de nicho. Construída com foco no alto desempenho, controlo total dos dados e extrema acessibilidade de hardware.

---

## 🚀 Visão Geral e Objetivo do Projeto

O objetivo desta VTT é preencher a lacuna entre os ambientes de desktop de alta performance e os dispositivos móveis de baixo custo. O software foi concebido para funcionar perfeitamente em todo o espectro de hardware:

* **Dispositivos Móveis Alvo**: Otimizado para funcionar perfeitamente em dispositivos Android de baixo custo (smartphones e tablets abaixo de 200€), bem como em hardware premium Apple iOS/iPadOS.
* **Ecossistemas de Ambiente de Trabalho**: Suporte nativo completo para Windows, macOS e Linux (qualquer distribuição).

### 🛠️ Tecnologias

* **Linguagem e Framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform para interface de utilizador e lógica de negócio 100% partilhadas entre dispositivos móveis e desktops.
* **Armazenamento Local**: SQLDelight para uma gestão rápida, segura em relação a tipos e multiplataforma de base de dados incorporada.
* **Ambiente de Desenvolvimento**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Política de Privacidade, Segurança de Dados e Monetização

Este software foi desenvolvido com base nos princípios fundamentais de privacidade do utilizador, propriedade total dos dados e transparência absoluta:

* **Arquitetura 100% Offline e Local**: O sistema opera completamente offline. Todos os dados, compêndios, campanhas e fichas de personagens são guardados exclusivamente numa base de dados local segura no seu dispositivo físico.
* **Sem Sincronização com a Nuvem e Sem Rastreio de Terceiros**: O software não envia os seus dados pessoais para qualquer servidor externo, nem distribui ou vende a sua informação a terceiros.
* **Aviso de Autenticação**: Os dados pessoais são utilizados exclusivamente para gerar o login do seu perfil local (e-mail e palavra-passe). Como não existe uma base de dados centralizada na cloud, **perder a palavra-passe ou o e-mail registado significa perder o acesso à sua conta e aos seus dados locais permanentemente**. Não existe função de "redefinição de palavra-passe" no servidor.
* **Sem Anúncios, Telemetria ou Bloatware**: O código-fonte é público e pode ser visualizado por qualquer pessoa no GitHub para garantir a completa ausência de adware, bloatware, scripts de rastreio, telemetria oculta ou publicidade enganosa.
* **Sem Microtransações**: O software não apresenta microtransações, compras na aplicação, paywalls ou mecânicas de jogo desbloqueáveis ​​pagas de qualquer tipo.

---

## 🏗️ Ecrãs e Funções do Jogo

#### 🔐 Autenticação

* Ecrã de login universal para sessões de campanha locais.

#### 👑 Tela do Mestre (DM)

* **Compêndio Universal**: Um navegador de documentação integrado e ultrarrápido que carrega os manuais de forma adaptativa, dependendo do sistema de jogo ativo.
* **Gestão de Manuais**: Suporte para armazenamento local de manuais, leitura de dados diretamente do armazenamento interno, unidades USB externas ou cartões microSD.
* **Painel de Campanha**: Visão geral da campanha, lançador de dados digital, fichas de NPCs e criadores de itens personalizados que inserem conteúdo na base de dados sem alterar a base de dados de regras principal.
* **Central de Aprovação**: Central de notificações em tempo real para aprovar ou negar modificações na ficha de personagem solicitadas pelos jogadores.

#### ⚔️ Ecrã do Jogador

* **Ficha de Personagem Interativa**: Fichas de personagem totalmente interativas e editáveis ​​com um lançador de dados integrado.
* **Acesso Direcionado às Regras**: Acesso direto aos manuais do jogo, filtrados estritamente para as mecânicas que afetam os jogadores (Habilidades, Magias, Talentos, Condições de Estado, Raças e Classes).
* **Mecanismo de Sincronização e Alerta**: Qualquer alteração estrutural efetuada na ficha da personagem desencadeia automaticamente um alerta para o Mestre, aguardando aprovação antes de se tornar permanente.

---

## 📄 Licença

Este projeto está protegido e licenciado sob a **Licença Estrita PolyForm 1.0.0**.

### ⚠️ Uso Não Comercial e Restrito

* **Permitido**: Pode utilizar este software livremente para passatempos pessoais, investigação académica, estudo ou campanhas sem fins lucrativos.
* **Proibido**: **não pode** utilizar este software ou o seu código-fonte para quaisquer fins comerciais, de monetização ou dentro de uma empresa.
* **Proibido**: A modificação e redistribuição deste código por terceiros são **estritamente proibidas**. Apenas o autor original detém os direitos de distribuição e modificação.

Para obter todos os detalhes legais, leia o ficheiro [LICENSE.md](./LICENSE.md) oficial no diretório raiz.

### 🌐 Localizações da Licença
Para ajudar os programadores de todo o mundo a compreender estas restrições, estão disponíveis traduções de cortesia na pasta [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italiano)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Reference Copy)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Francês)](<./Localização/Licenciatura/LICENSE.fr.md>)
* 🇪🇸 [Español (Spanish)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Alemão (Alemão)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (chinês)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (chinês)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japonês)](<./Localization/License/LICENSE.ja.md>)
* ...e [muitos outros idiomas](./LICENSE.md).

*Nota: A versão oficial em inglês no diretório raiz é o único texto juridicamente vinculativo. *
