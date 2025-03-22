# Documentação do Business Card App

## Visão Geral
O **Business Card App** é um aplicativo desenvolvido em **Jetpack Compose** para exibir um **cartão de visita digital**. O aplicativo mostra informações básicas, como nome, função e contatos (telefone, username e e-mail), organizadas de maneira responsiva.

## Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Framework:** Jetpack Compose
- **Bibliotecas:** Material 3

## Estrutura do Projeto
O projeto é composto pelos seguintes arquivos principais:

### **1. MainActivity.kt**
Responsável por inicializar a interface do aplicativo.
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinesCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}
```

### **2. BusinessCard.kt**
Componente principal que define o layout do cartão.
```kotlin
@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(R.drawable.android_24dp_e3e3e3),
                contentDescription = stringResource(R.string.android_logo),
                modifier = Modifier.size(120.dp),
            )
            Text(
                text = stringResource(R.string.nome_completo),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.funcao),
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            CriarRow(R.drawable.call_24dp_e3e3e3, R.string.numero_telefone, R.string.numero_telefone)
            CriarRow(R.drawable.share_24dp_e3e3e3, R.string.username, R.string.nome_de_usuario)
            CriarRow(R.drawable.email_24dp_e3e3e3, R.string.email, R.string.email_do_usuario)
        }
    }
}
```

### **3. CriarRow.kt**
Função auxiliar para criar uma linha com ícone e texto.
```kotlin
@Composable
fun CriarRow(icon: Int, texto: Int, description: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp),
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = description),
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp)
        )
        Text(text = stringResource(id = texto))
    }
}
```

### **4. Preview do Cartão**
Utilizado para visualizar o layout no Android Studio.
```kotlin
@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp",
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}
```

## Como Rodar o Projeto
1. Clone o repositório ou copie os arquivos para o **Android Studio**.
2. Execute o projeto em um **emulador** ou **dispositivo físico**.
3. Visualize o cartão de visita e interaja com os componentes.

## Conclusão
O Business Card App é um exemplo prático de como usar **Jetpack Compose** para criar uma interface moderna e responsiva. O código segue boas práticas de desenvolvimento e pode ser facilmente expandido para novas funcionalidades.

