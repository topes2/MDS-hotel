No âmbito da unidade curricular de Metodologias e Desenvolvimento de 
Software, foi-nos proposto implementar o sistema desenvolvido na primeira 
parte do trabalho, tendo como referência o Diagrama de Classes já realizado.  

Este README tem como principal objetivo apresentar de forma clara e organizada 
as **decisões tomadas** durante o desenvolvimento do projeto.

Uma das primeiras decisões foi a junção de dois *casos de uso* num único issue.  
Estes casos de uso, "Funcionário Fazer Pedido de Manutenção" e "Hóspede Fazer 
Pedido de Manutenção", foram unificados num só issue, "Funcionário e Hóspede 
fazer um Pedido de Manutenção", porque o seu comportamento e a lógica associada 
eram idênticos, tanto na descrição como na implementação.  

Para gerir o desenvolvimento do projeto, seguimos uma abordagem estruturada 
utilizando o Git. O fluxo de trabalho foi o seguinte:

```bash
    git branch (NomeDaIssue)
    git checkout (NomeDaIssue)
```

Durante o trabalho na branch, realizávamos alterações, adicionávamos os 
ficheiros modificados e criávamos commits descritivos:

```bash
    git add caminho/para/o/ficheiro
    git commit -m "Título:" -m "Descrição:" -m "Referência à Issue #X"
    git push origin NomeDaIssue
```

Quando um issue era concluído, procedíamos à integração das alterações na 
branch de desenvolvimento *dev*:

```bash
    git checkout dev
    git merge (NomeDaIssue)
    git push origin dev
```

No final procedemos ao versionamento do software, fazendo-se assim merge do branch
*dev* para o branch *main*.  
Depois foi adicionada a tag *v1.0* ao branch main.