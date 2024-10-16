# Course Stack

#### Colaboradores

El desarrollo de este proyecto ha sido posible gracias a la colaboración del **grupo #3**:

- **Patricia Cibeira**
- **Diego Heredia**
- **Edwyn Guzmán**
- **Simón Uzcategui**
- **Omerin Otamendis**

**Agradecimientos:**
A todos los que han contribuido de alguna manera a este proyecto, ¡muchas gracias!

### Área de trabajo local

Para poder trabajar en el proyecto utilizando Visual Studio Code, se recomienda seguir los siguientes pasos después de clonar el repositorio:

1. Crea una carpeta llamada **.vscode** en la raíz del proyecto.
2. Dentro de la carpeta **.vscode**, crea un archivo llamado **settings.json**.
3. Copia y pega la siguiente estructura dentro del archivo:

```json
{
  "java.project.sourcePaths": ["src"],
  "java.project.outputPath": "bin",
  "java.project.referencedLibraries": [
    "./src/lib/sqlite/sqlite-jdbc-3.46.0.1.jar",
    "./src/lib/sqlite/slf4j-api-1.7.36.jar",
    "./src/lib/Glasspane/glasspane-popup-2.0.1.jar",
    "./src/lib/Glasspane/miglayout-4.0.jar",
    "./src/lib/TimingTargetAdapter/TimingFramework-0.55.jar"
  ],
  "java.project.exportJar.targetPath": "${workspaceFolder}/build/Course stack.jar"
}
```

> #### **IMPORTANTE**
>
> Asegúrate de tener instalada la extensión **Extension Pack for Java** en Visual Studio Code. De esta forma podrás ejecutar el programa desde el editor.

## Modelo de Dominio

Esta es la primera versión del modelo de dominio. En este modelo muestra el **¿Que?** del proyecto desde un **enfoque abstracto**, de manera que muestre de forma sencilla las realciones del diagrama.

![ModeloDeDominio](https://www.plantuml.com/plantuml/png/PLBBZjim3BphAuWS2tY1HM-B7jQrSsonA9BSkHAJif55WvBIHTD-LD5Fs1yhP3ilvoODoHaEoUUOK5FkF7mHHrvQQgNZm6BYdaEFYXrybKIVqUvtAZcuHhme9CKGUrGAQPufwaZli-Jr1za4wvXHMOu60218zweqFB4dxzd9yB6YIgTdI8gHtl-Y-MDEB2yglGGAYKQYddJBlXLRe059t4jBBmDkPfMPOiAniA293wFMDWVB4h1Z2cc2Oj9iKrPiiYhRx5670CMac6Z7k3oWpvZuW6FWZNSKB6CSlYuh5j9pqSZMKYDnqh0gGNQAtRN3sZEwQKp5oyJTa-F1uoLpKH_GmufiO2iBm0ZrwbWiJt5qPQ6bNISAn-jXh9lDgA2ylMPiiaO1Hx1yInGYl_yB0t6plDkRHKMRQ1pALhJ3oTMvwKuSUdRexbBEixdNRhdtqc4wMMhQgVFfVW0-_QugvTttcK6pRZPGLJFmSYybThu14oGHI03FOGzFy8tGyoyqpH8-tEITL8keav_XwW1lkNCFzSgCouDJW_NgHkYfLBjiRqeNZmyFZukneAggylsuW6OvRt4gAIrU9j2qvdRBKbK5h5VtevZnRORT6FDCmUNE_mS0)

En el siguente diagrama de estados muestra el **proceso de negocios que se quiere automatizar**. En este caso es el proceso para proponer cursos.

![ProcedoDeNegocio](https://www.plantuml.com/plantuml/png/VLBBRjim4BppAnQvwn3x5XXEt5Q708OjE85Flcp8hSrQtYMMbD7sj_e11TeVAoW_Oab1JvHsPsPdXtoA2JKrXneg5KjElj22jcAzcBZt753n00j9z0djVglIiFiijIWaHOu1bJZraQAET8ZQUKT0Xv1-WADerOVaXKrCc0Zku9czzQWGANhXEy08B-td6M65dSyChEzXCh4xyPQcqs5tzD_kUDXj8u39f3slLMANvn2xszAeLrhHriUag71PP4qAyXP9ZsYzCCLsbVNoqY-_1s5I22gXePYmxPVLjN_4ka7h__vYS0GRhh67FPBwhzxYRNop8zQGoBAt0XkM9Bf59or-zdeTNbs4OCDATeS_qPr4gzNLG0nasm4AGTGI9_oMZJY2kh4gPyDpOqx95TFpJO4vdqKnxToNOKa4mb1xtiC3_FbzoSt9e-dSR35zpxHFMuXvpxiTKbOzjZiLEqHuW1TloYfhTxAx_O6kvT7GyinIIEYmOtYKUUlb1qxNIoYQhkYu0ykQpvo8aqHmFWPX_rPJxEYFeT2yQBNwO4GNDroytRjQvLP-pJtVEQhyD8QKsUlo93StPJK_qqVcYTWrX_eV)

## Modelo de Casos de Uso

En este diagrama mostramos el **¿Como?** del proyecto. Este representa los casos de uso mas relevantes.

![UseCase](https://www.plantuml.com/plantuml/png/RP5DRjj038NtSmeYgtQX740mXBYs8NXJ24tgLJRC3ADEFI853XKqA7gWhdk4NApGZrsxxMw6ttipZ-HTDbGRkWIVCsqmaqlqR6026jil1Y4gUOl2BXyZzwZOGO_-Y2tTssiY635oc-X2y56CFg0_jYe3XuqaKJ15pZqgiVsj50sa_whAHgKN9ZOg0JFqvwihrw6B7BCf1b7A4yVBcYlNAMAGcKn7vyvPuMOZWsQ2UqD_lFdk003UxJdwA108CkNuzelVZ-RnB3mhFb4xVQ0JqTDjXZKnAUgKSw1iE8dgPgO7qlWSFIgCACW43xjhAxvW0dlxwJdwML6l7wubNeMbLUpmaSUez9NyuCUqZmolu2NRujpiDilNc690XSX6R997OyozS7nAbESW-wtxCGvewGXMnN2xj5x2QXNPfo5GLRcwWTlgWj0t8mwvgjnXlvrjTLDUEWuxM9tUWckB-xDJA8hJgETrGJ4KnTp5rMQN-lhXF-MwAM5BHjf5HaW8sAiyuJIUyxEJkOINPI7EtH67eKk_0G00)

## Diagrama de Base de datos

Este tipo de diagrama es fundamental para entender cómo se almacenan y acceden a los datos dentro de un sistema de gestión de bases de datos

![DatabaseDiagram](https://www.plantuml.com/plantuml/png/bLJ1Yjj03BtxAmQVsaC2kUQqIyO1qouRqjr3Zegj3GhZKP1cGg7qe_eD_R5YnmaUnsdfoLXFw3qzIVEa0IJ4nXaB0VQWQ0aE0asMyVw8LJ0RuHDxz07rHsQC6GHAkoGVpAVDbyyTic8HvANH8EGFVSW70SNVls1fo8Sk-4OdjhX1KVPmI_zvetok6_AaGQ1ckT8cmT9srVwV-jrJ3VK4f-KgDkW3gyKj7beYxfadeTAQjFd4bekuTGzjotMYhFpsTPjAZI9KHHUR9Fn68Jf-ztH6KGeWb7Pu5VE2Ke4Fv8Pz9GECg046y-l-n-FxImSN9UPQtrnyGSyDUQY8VQBhTN_4G6VMtJhw6bhlxfCsA1_aB9R-8AYyAxhFL0fNhQO4AJH8h48Kk5e7ic5PSNF2WBuYqBjy27WWK8l56Lpi1Erib7jbnNSwN6eK_WK22e53tIdAcIfYVQ34ueerZE2LiEVsdi1YSSGgjcpFFe9BqYvhkKKziLVOkxJR5KY0rgc0Ts9xhErSkA61WuFbtg965w1c7I_3579tNCEDIVTY-YYlwEk-zQmp67MqkJrjih7NytVK2khFllkPbFHWLn-hdHp6FwPPq6K_DRsjATzCliXditoH3quk6xrb9byOO_APcvdSBEPpdq-E89jySpg2U6FeN-KiKJ2VUvFFP9QRKLRlweCQOxHJDj2JFQ6lO-F-0000)
