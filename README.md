# 🖨️ Sistema de Controle de Impressora Elgin
Grupo: PrintMarcosNazyVitorLira
---

## 📘 Sobre o Projeto

*Este sistema foi criado por um grupo de alunos que buscavam cumprir o projeto requerido pelo professor Richard 69. Aqui o usuário pode desfrutar de uma conexão simples com a impressora que tiver, a única necessidade é que saiba os tipos de comunicação com a própria impressora para que este projeto seja acessível à muitos tipos de máquina.*


---

## 🧰 Tecnologias Utilizadas

- **Java** *(informe a versão que você usou)*
- **IntelliJ IDEA** *(ou a IDE que usou)*
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora01** (SDK da Elgin)
- **Impressora Elgin i8 ou i9** *(informe qual você usou nos testes)*

---

## 📁 Estrutura do Projeto

```
/src                      → Código-fonte
   Main.java              → Inicia o programa
   Impressora.java        → Conecta o ImpressoraDLL.Java com o menu por meio de funções
   Menu.java              → A trilha do usuário
   Usuario.java           → Funções de login
/Bibliotecas E1 Impressora → DLLs da Elgin (x64 e x86)
/libs Java                → jna-5.15.0.jar
```

---

## ⚙️ Instalação e Execução

### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado.
3. Conecte e ligue a impressora.
4. Abra `Main.java` e clique em ▶️ **Run**.

### 3. Efetuar cadastro e login
1. Escolha um nome de usuário decente
2. Decida uma boa senha
3. Logue na conta cadastrada e comece a imprimir

### 4. Configure a Conexão da Impressora
1. Tipo: Informe qual será o tipo da conexão (Ex: USB, Bluetooth e etc.)
2. Modelo: Informe o modelo da sua impressora
3. Conexão: Informe a forma da impressão (Ex: USB, COM2 ou IP)
4. Parâmetro: Apenas se for necessário para conexão com sua impressora (Ex: 0 para USB, velocidade ou porta TCP)

---

## 🔐 Login

*Você pode escolher seu LOGIN quando for se cadastrar, assim que se cadastrar
terá até 3 tentativas para logar com o usuário
e senha cadastrados, caso falhe o sistema reiniciará*

---

## 📋 Funcionalidades do Menu

| Opção | O que faz                          |
|-------|------------------------------------|
| 1     | *Configurar Conexão*               |
| 2     | *Abrir Conexão*                    |
| 3     | *Fechar Conexão*                   |
| 4     | *Imprimir Texto*                   |
| 5     | *Imprimir QR Code*                 |
| 6     | *Imprimir Código de Barras*        |
| 7     | *Imprimir XML Sat*                 |
| 8     | *Imprimir XML de Cancelamento SAT* |
| 9     | *Abrir Gaveta*                     |
| 10    | *Sinal Sonoro (BIP)*               |
| 11    | *Avançar Papel (Extra)*            |
| 12    | *Sair*                             |


## 🧪 Testes Realizados

*Testamos diversas funcionalidades, como as tentativas
no login, bips na impressora, abrir gaveta, imprimir QR Code, 
imprimir Texto e etc. Tudo funcionando, a única correção necessária 
foi colocar valores padronizados para que um usuário leigo possa usufruir 
da impressora*

---

## 📚 Documentação Adicional

- Manual da impressora Elgin
- Documentação do SDK E1_Impressora
- Instruções do Professor Richard
- Instruções do Gemini

---

## 👥 Autores
*(em ordem alfabética)*

- Brayan Lira 
- Gabriel Azevedo
- João Vitor
- Heitor Nagy
