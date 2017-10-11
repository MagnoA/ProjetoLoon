| Questões      | Valor total | Valor obtido |
| ------------- | :---------: | :----------: |
| bloco inicial |      2      |      2       |
| 1, 2 e 3      |      2      |      2       |
| 4, 5 6 e 7    |      3      |      3       |
| 8             |      3      |      3       |

**Total:** 10 - 1 dia de atraso = 9


- Crie um projeto gradle Java com a IDE IntelliJ
  - Marque a opção Use auto-import
  - Em Project Location escolha o diretório onde você fez o clone desse repositório do github classroom

**Correção:** OK


- Arquivo .gitignore para excluir arquivos do gradle, Java, Linux e Jetbrains IDE (IntelliJ)

**Correção:** OK

- Arquivo LICENSE para indicar o licenciamento do código

**Correção:** OK

- Testes de unidade com JUnit4 para validar as implementações das principais classes

**Correção:** OK

- Respeitar o conceito de encapsulamento, fazendo uso adequado dos modificadores de acesso

**Correção:** OK

- Documentar os principais métodos seguindo a sintaxe do JavaDOC

**Correção:** OK



1. Desenhe um diagrama de classes UML representando as classes e associações entre essas. Para cada classe é necessário indicar todos os atributos e somente os métodos essenciais para entendimento da classe
   1. O diagrama deverá ser entregue como uma figura PNG. Na raiz do repositório deve-se criar um arquivo Resolucao.md e fazer nesse uma referência para a figura do diagrama
     **Correção:** OK  

2. Implemente em Java todas as classes do diagrama UML da questão anterior
  **Correção:** OK

3. Desenvolva um aplicativo Java (uma classe Java com método main) com um menu interativo que permita ao usuário realizar as seguintes operações
   1. Cadastrar estação rádio base terrestre
      1. A distância mínima entre uma ERB terrestre e outra deve ser de 40km. Não existe distância máxima. Ou seja, não é permitido cadastrar uma ERB que esteja a uma distância menor que 40km de qualquer outra ERB já cadastrada. A localização de cada ERB se por coordenadas geográficas (latitude, longitude)
        **Correção:** OK
   2. Remover estação rádio base terrestre
     **Correção:** OK
   3. Imprimir os dados de todas estações rádio base terrestres
     **Correção:** ok
   4. Lançar balão
      1. Se for o primeiro balão a ser lançado, então esse não terá vizinho. Se houver algum balão lançado, então o sistema deverá automaticamente preencher o identificador desse como sendo vizinho do balão que está para ser lançado
        **Correção:** OK
   5. Imprimir todos os dados de um balão específico
      1. Usuário fornece o identificador do balão
        **Correção:** OK
   6. Simular a movimentação dos balões
      1. Usuário fornece a unidade de deslocamento horizontal e essa é aplicada em todos os balões
        **Correção:** OK
   7. Imprimir o identificador e as coordenadas de todos os balões
     **Correção:** OK
   8. Simular o usuário enviando uma mensagem e essa sendo entregue em uma ERB
      1. O usuário fornecerá a sua localização e o conteúdo da mensagem a ser enviada. O sistema deverá automaticamente enviar a mensagem para o balão mais próximo do usuário
      2. Deve-se imprimir a rota percorrida pela mensagem até ser entregue na ERB (i.e. identificadores dos balões por onde passou a mensagem)
        **Correção:** OK
   9. Sair do programa
