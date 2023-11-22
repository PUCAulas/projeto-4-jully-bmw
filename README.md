[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12991884&assignment_repo_type=AssignmentRepo)
# Sistema de Gerenciamento de Biblioteca 2.0 Período

Os usuários do sistema de gerenciamento de biblioteca anterior se queixam das mensagens recebidas ao
tentarem pegar itens emprestados. Simplesmente surge uma mensagem de erro que não são capazes de
traduzir. As possibilidades são as seguintes:

(a) tiver algum livro em atraso, 

(b) já tiver 3 livros em sua posse,

(c) o livro for o último exemplar disponível e 

(d) ele já possuir um exemplar do que está tentando pegar
(novo).

Além disso, alguns estudantes relataram tédio na seleção de novos itens e sugeriram um sistema
de recomendação. Adicionalmente, os funcionários da biblioteca se queixam do menu, dizem que a
produtividade é baixa porque a interface é ruim. Apesar desses problemas, o software tem suprido as
necessidades dessa biblioteca custando muito pouco, razão de outras bibliotecas se interessarem por ele.
No entanto, o desenvolvimento do software não envolveu práticas tão boas de desenvolvimento e
queremos corrigir isso para comercializá-lo.
Requisitos:

a) Não deve ser possível pegar emprestado exemplares repetidos;

b) Sistema de recomendação: o sistema deverá conter uma funcionalidade de recomendação de livros
que seja relacionada com os interesses dos usuários. Para aferição dos interesses do usuário devem ser
verificadas:

- as declarações do usuário sobre categorias de interesse;
- o histórico do usuário na biblioteca;
- o curso do aluno;

O sistema deve recomendar pelo menos 3 itens que, de acordo com a lógica definida, se relacionam
com os interesses do usuário. Os itens recomendados devem ser ranqueados do mais interessante
para o menos interessante para o usuário (não importa se emprestáveis ou não).

c) Interface gráfica com o usuário: deverá haver uma interface gráfica para os cadastros de usuários e
itens da biblioteca.

d) As situações narradas no enunciado, em que o estudante não pode efetuar um empréstimo, devem ter
tratamentos de erro com mensagens condizentes com o erro (utilizar blocos try-catch).

e) Deve haver uma única instância da classe Biblioteca e não deve ser possível instanciar outra
(padrão de projeto: singleton);

f) A criação de itens de biblioteca deve ser feita por meio de métodos factory (padrão de projeto: factory
method);

g) A funcionalidade do requisito b) exige que a classe usuário possua atributos “curso” e “categorias de
interesse”. Para essa funcionalidade deve ser implementada uma classe adaptada (padrão de projeto:
adapter).

h) O desenvolvimento deve atender aos princípios SOLID;

## Alunos integrantes da equipe

- Belle Nerissa Aguiar Elizeu
- Jully Ketely Alves da Silva
- Maria Aryene Costa dos Santos
- Warley Leandro dos Anjos

## Professor responsável 

- Juliana Padilha

