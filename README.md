# KartRank

Implementação simples de uma solução para o problema proposto em https://github.com/devamil/kart-rank

## Build

Certifique-se que o JDK 8   está corretamente instalado, configurado e funcionando em sua máquina.
Certifique-se que o Maven 3 está corretamente instalado, configurado e funcionando em sua máquina.

Clone ou faça o download do repositório.

## Execução

Basta executar os comandos abaixo para ver o resultado a partir do console da classe JUnit de teste.

```
mvn clean
mvn test
```
## Arquivo de entrada

O arquivo de entrada está localizado em src/main/resources chamado corrida.txt. 

## Exemplo de execução

### Arquivo de entrada

```
23:49:08.277      038 – F.MASSA             1     1:02.852            44,275
23:49:10.858      033 – R.BARRICHELLO       1     1:04.352            43,243
23:49:11.075      002 – K.RAIKKONEN         1     1:04.108            43,408
23:49:12.667      023 – M.WEBBER            1     1:04.414            43,202
23:49:30.976      015 – F.ALONSO            1     1:18.456            35,47
23:50:11.447      038 – F.MASSA             2     1:03.170            44,053
23:50:14.860      033 – R.BARRICHELLO       2     1:04.002            43,48
23:50:15.057      002 – K.RAIKKONEN         2     1:03.982            43,493
23:50:17.472      023 – M.WEBBER            2     1:04.805            42,941
23:50:37.987      015 – F.ALONSO            2     1:07.011            41,528
23:51:14.216      038 – F.MASSA             3     1:02.769            44,334
23:51:18.576      033 – R.BARRICHELLO       3     1:03.716            43,675
23:51:19.044      002 – K.RAIKKONEN         3     1:03.987            43,49
23:51:21.759      023 – M.WEBBER            3     1:04.287            43,287
23:51:46.691      015 – F.ALONSO            3     1:08.704            40,504
23:52:01.796      011 – S.VETTEL            1     3:31.315            13,169
23:52:17.003      038 – F.MASS              4     1:02.787            44,321
23:52:22.586      033 – R.BARRICHELLO       4     1:04.010            43,474
23:52:22.120      002 – K.RAIKKONEN         4     1:03.076            44,118
23:52:25.975      023 – M.WEBBER            4     1:04.216            43,335
23:53:06.741      015 – F.ALONSO            4     1:20.050            34,763
23:53:39.660      011 – S.VETTEL            2     1:37.864            28,435
23:54:57.757      011 – S.VETTEL            3     1:18.097            35,633
```

## Saída

```
------------------------------------- resultado da corrida -------------------------------------
Posição Chegada | Código Piloto | Nome Piloto   | Qtde Voltas Completadas | Tempo Total de Prova
1               | 38            | F.MASSA       | 4                       | 4:11.578
2               | 2             | K.RAIKKONEN   | 4                       | 4:15.153
3               | 33            | R.BARRICHELLO | 4                       | 4:16.80
4               | 23            | M.WEBBER      | 4                       | 4:17.722
5               | 15            | F.ALONSO      | 4                       | 4:54.221
6               | 11            | S.VETTEL      | 3                       | 6:27.276

------------------------------------------------------------- Bônus -------------------------------------------------------------
Posição Chegada | Código Piloto | Nome Piloto   | Melhor volta | Velocidade média | Tempo Chegada | Tempo chegada após o vencedor
1               | 38            | F.MASSA       | 3            | 44.24575         | 4:11.578      | 0:00.0
2               | 2             | K.RAIKKONEN   | 4            | 43.62725         | 4:15.153      | 0:03.575
3               | 33            | R.BARRICHELLO | 3            | 43.468			  | 4:16.80       | 0:04.502
4               | 23            | M.WEBBER      | 4            | 43.191254		  | 4:17.722      | 0:06.144
5               | 15            | F.ALONSO      | 2            | 38.06625		  | 4:54.221      | 0:42.643
6               | 11            | S.VETTEL      | 3            | 25.745667		  | 6:27.276      | 2:15.698
---------------------------------------------------------------------------------------------------------------------------------

Melhor volta da corrida : Volta 3 - 38 - F.MASSA - 44.334
```
