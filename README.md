# Trabalho_Estrutras_Dados
Pedro Henrique de Souza Ramos
Herick Doulgas 

Jogo de Dominó onde um player humano joga contra o computador com uma lógica implementada.

Foram criadas 3 listas, a lista de peças jogadas, que começa vazia e vai recebendo as peças que os jogadores escolhem jogar.
Logo em seguida o programa remove aleatóriamente 7 peças dessa lista e implementa elas na lista de peças do jogador humano e depois remove mais 7 peças e implementa na lista de peças do computador.
O player humano começa a partida com o programa imprimindo na tela suas peças.
Para jogar a peça o player deve digitar o número referente a ordem da peça que foi imprimida. Não há verificação no caso do player se essa peça é válida ou não, então cabe ao jogador selecionar a peça adequada.
Na vez do computador, o programa verificará se tem uma peça correta para jogar de acordo com o número das extremidades da lista de peças jogadas.
Caso tenha uma peça com um número igual ao de alguma extremidade da lista de peças jogas, o programa fará sua jogada. Caso não tenha, o programa comprará automaticamente uma peça da lista. Caso seja possível jogar a peça, o programa jogará automaticamente, caso não seja possível, o computador passará a vez.
A lista de peças jogadas é imprimida na tela após o computador fazer sua jogada
O player volta a jogar. Caso o player não tenha uma peça correta para jogar, ele deverá comprar uma peça da lista de peças digitando 5.
Após comprar a peça ele deverá analisar a peça comprada, e se ela não puder ser jodada, ele deverá digitar 10 para passar a vez.
As peças jogadas são removidas lista de quem jogou e são implementadas na lista de peças jogadas.
Se o player jogar todas as suas peças primeiro, o programa imprime uma mensagem de vencedor e finaliza.
Se o computador jogar todas as suas peças primeiro, o programa imprime uma mensagem de perdedor e finaliza.
