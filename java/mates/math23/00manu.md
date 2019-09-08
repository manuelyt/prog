# que hice en este proyectito

### problema

me lei este articulito

https://www.freecodecamp.org/news/interview-questions/

y me gusto, pero me chirrio un poco, asi que me puse a rascar un poco, y mira por donde me encontre con esto

el colega en el articulo hace una rutitina para devolver esto :

1) 1/3 = 0.(3)
2) 1/4 = 0.25
3) 1/5 = 0.2
4) 1/6 = 0.1(6)
5) 1/7 = 0.(142857)
6) 1/8 = 0.125

pero creo que esta mal, falla para numeros grandes

 1 / 59 = 0.0(1694915254237288135593220338983050847457627118644067796610)


### solucion

para verlo probe a dividir 1 entre primos un poco mas grandes, 
y parece que lo que decia el articulo esta mal

para ver las divisiones con mucha precision tuve que usar la clase bigfraction de la api de apache de mates

			<groupId>org.apache.commons</groupId>
			<artifactId>commons-math3</artifactId>

bye
			