# GoBots

### SOBRE
Um serviço que aceita chamadas RESTful, tendo um endpoint que recebe uma string de texto e retorna uma string com termos da Internetês "traduzidos" para uma escrita mais formal, sendo possível apagar, procurar e mudar as mensagens.

### INSTALAÇÃO
> - Instale Visual Studio Code e MySQL;
> - Necessário baixar o aquivo () para inserir no MySQL;
> - Criar um SCHEMA no MySQL com o nome gobots;
> - Clicar com o botão direito em cima do SCHEMA;Apertar na opção Table Data Import Wizard; 
> - Importar o arquivo baixado anteriormente;
> - Abrir esse projeto no Visual Studio Code;
> - Subir o servidor local usando `./mvnw spring-boot:run `;
> - Digite em seu navegador: `localhost:8080` para iniciar o uso do projeto; 
> - Agora, para que haja a "tradução" das palavras basta digitar alguma contida no banco de dados;

### FUNCIONALIDADES 

1. Página inicial - Uma página home simples com navbar para acessar as outras funcionalidades.
2. Nova mensagem - Funcionalidade principal do projeto, recebe nome e mensagem e exibe ambos sendo a mensagem tratada no banco de dados. Caso haja o termo da Internetês no banco de dados a mensagem será exibida de uma forma "traduzida".
3. Procurar mensagem - Recebe o nome completo e exibe na tela as mensagens enviadas por essa pessoa.
4. Apagar mensagem - Recebe o número de identificação da mensagem (ID) para apagá-la do banco de dados; (Para encontrar o número de identificação basta clicar na lista de mensagem).
5. Atualizar mensagem - Recebe o número de identificação da mensagem (ID) e a mensagem atualizada. (Essas modificações vão todas para o banco de dados).
- **OBS:** A mensagem traduzida só é exibida assim que enviar na funcionalidade 2.

### FRONT-END
Framework - Bootstrap para auxiliar na construção dos formulários.
>
Biblioteca - Google fonts para usar nas fontes do projeto.

----------------------------
#### CONSIDERAÇÕES FINAIS
Muito obrigado pela oportunidade :)
>
Desenvolver esse projeto foi um desafio mas acima de tudo uma grande oportunidade de aprender diversas coisas.

#### AUTOR
Yasmin Kaline de Carvalho  Silva
>
yasminkaline73@gmail.com
