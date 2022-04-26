# Microservicios

### Prerequisitos
Se recomienda contar con las siguientes versiones instaladas:
```
version de java: 15
version de compilador: 1.8
Apache maven: 3.6.3 
```

### Instalación
Para uso del proyecto requerimos clonar este repositorio. Siga los pasos:

1. Clonamos el repositorio con ayuda de git
```
git clone "https://github.com/gabrielaasilva/Microservicios_AREP"
```

2. Accedemos a la carpeta donde hemos clonado
```
cd Microservicios_AREP
```

3. Compilamos nuestro proyecto para generar el target
```
mvn package
```

4. Abrimos el proyecto con nuestro editor de preferencia
```
code .
```
5. Para conectarnos a nuestra maquina virtual usamos la consola y ejecutamos
```
ssh -i "Microservicios.pem" ec2-user@ec2-3-231-151-135.compute-1.amazonaws.com
```

6. y nuestra aplicacion se encuentra en el directorio 
```
cd /home/Microservicios_AREP
```

7. Si queremos ejecutar nuestra aplicacion desde la maquina virtual usamos
```
java -cp "target/classes:target/dependency/*" edu.escuelaing.arep.App
```

## Evidencias EC2

![](https://github.com/gabrielaasilva/Microservicios_AREP/blob/master/Resources/img1.jpeg)
![](https://github.com/gabrielaasilva/Microservicios_AREP/blob/master/Resources/img2.jpeg)
![](https://github.com/gabrielaasilva/Microservicios_AREP/blob/master/Resources/img3.jpeg)

## Programa hecho con

* [Maven](https://maven.apache.org/) - Dependency Management

## Actores

* **Ana Gabriela Silva** - [gabrielaasilva](https://github.com/gabrielaasilva)
* **Juan Camilo Gil** - [jua1000n](https://github.com/jua1000n)
* **Juan Sebastián Cadavid** - [juank544](https://github.com/Juank544)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.txt) file for details

