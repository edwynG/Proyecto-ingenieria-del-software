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
  "java.debug.settings.onBuildFailureProceed": true
}
```

> #### **IMPORTANTE**
>
> Asegúrate de tener instalada la extensión **Extension Pack for Java** en Visual Studio Code. De esta forma podrás ejecutar el programa desde el editor.

## Modelo de Dominio

Esta es la primera versión del modelo de dominio. En este modelo muestra el **¿Que?** del proyecto desde un **enfoque abstracto**, de manera que muestre de forma sencilla las realciones del diagrama.

![ModeloDeDominio](https://www.plantuml.com/plantuml/png/PLBBZjim3BphAuWS2tY1HM-B7jQrSsonA9BSkHAJif55WvBIHTD-LD5Fs1yhP3ilvoODoHaEoUUOK5FkF7mHHrvQQgNZm6BYdaEFYXrybKIVqUvtAZcuHhme9CKGUrGAQPufwaZli-Jr1za4wvXHMOu60218zweqFB4dxzd9yB6YIgTdI8gHtl-Y-MDEB2yglGGAYKQYddJBlXLRe059t4jBBmDkPfMPOiAniA293wFMDWVB4h1Z2cc2Oj9iKrPiiYhRx5670CMac6Z7k3oWpvZuW6FWZNSKB6CSlYuh5j9pqSZMKYDnqh0gGNQAtRN3sZEwQKp5oyJTa-F1uoLpKH_GmufiO2iBm0ZrwbWiJt5qPQ6bNISAn-jXh9lDgA2ylMPiiaO1Hx1yInGYl_yB0t6plDkRHKMRQ1pALhJ3oTMvwKuSUdRexbBEixdNRhdtqc4wMMhQgVFfVW0-_QugvTttcK6pRZPGLJFmSYybThu14oGHI03FOGzFy8tGyoyqpH8-tEITL8keav_XwW1lkNCFzSgCouDJW_NgHkYfLBjiRqeNZmyFZukneAggylsuW6OvRt4gAIrU9j2qvdRBKbK5h5VtevZnRORT6FDCmUNE_mS0 "ModeloDeDominio")

En el siguente diagrama de estados muestra el **proceso de negocios que se quiere automatizar**. En este caso es el proceso para proponer cursos.

![ProcedoDeNegocio](https://www.plantuml.com/plantuml/png/VLBBRjim4BppAnQvwn3x5XXEt5Q708OjE85Flcp8hSrQtYMMbD7sj_e11TeVAoW_Oab1JvHsPsPdXtoA2JKrXneg5KjElj22jcAzcBZt753n00j9z0djVglIiFiijIWaHOu1bJZraQAET8ZQUKT0Xv1-WADerOVaXKrCc0Zku9czzQWGANhXEy08B-td6M65dSyChEzXCh4xyPQcqs5tzD_kUDXj8u39f3slLMANvn2xszAeLrhHriUag71PP4qAyXP9ZsYzCCLsbVNoqY-_1s5I22gXePYmxPVLjN_4ka7h__vYS0GRhh67FPBwhzxYRNop8zQGoBAt0XkM9Bf59or-zdeTNbs4OCDATeS_qPr4gzNLG0nasm4AGTGI9_oMZJY2kh4gPyDpOqx95TFpJO4vdqKnxToNOKa4mb1xtiC3_FbzoSt9e-dSR35zpxHFMuXvpxiTKbOzjZiLEqHuW1TloYfhTxAx_O6kvT7GyinIIEYmOtYKUUlb1qxNIoYQhkYu0ykQpvo8aqHmFWPX_rPJxEYFeT2yQBNwO4GNDroytRjQvLP-pJtVEQhyD8QKsUlo93StPJK_qqVcYTWrX_eV "ProcedoDeNegocio")

## Modelo de Casos de Uso

En este diagrama mostramos el **¿Como?** del proyecto. Este representa los casos de uso mas relevantes.

![UseCase](https://www.plantuml.com/plantuml/png/RP5DRjj038NtSmeYgtQX740mXBYs8NXJ24tgLJRC3ADEFI853XKqA7gWhdk4NApGZrsxxMw6ttipZ-HTDbGRkWIVCsqmaqlqR6026jil1Y4gUOl2BXyZzwZOGO_-Y2tTssiY635oc-X2y56CFg0_jYe3XuqaKJ15pZqgiVsj50sa_whAHgKN9ZOg0JFqvwihrw6B7BCf1b7A4yVBcYlNAMAGcKn7vyvPuMOZWsQ2UqD_lFdk003UxJdwA108CkNuzelVZ-RnB3mhFb4xVQ0JqTDjXZKnAUgKSw1iE8dgPgO7qlWSFIgCACW43xjhAxvW0dlxwJdwML6l7wubNeMbLUpmaSUez9NyuCUqZmolu2NRujpiDilNc690XSX6R997OyozS7nAbESW-wtxCGvewGXMnN2xj5x2QXNPfo5GLRcwWTlgWj0t8mwvgjnXlvrjTLDUEWuxM9tUWckB-xDJA8hJgETrGJ4KnTp5rMQN-lhXF-MwAM5BHjf5HaW8sAiyuJIUyxEJkOINPI7EtH67eKk_0G00 "UseCase")

## Diagrama de Base de datos

Este tipo de diagrama es fundamental para entender cómo se almacenan y acceden a los datos dentro de un sistema de gestión de bases de datos

![DatabaseDiagram](https://www.plantuml.com/plantuml/png/dPJ1Yjj038RlVeh1f_RWGAuvxPBnGcYN3TdTGuwAhHg5yIX8Cw5G-b1zXhvOiUEa6SURGa_6-iNe6_tIF6W02R5rnaA07IXQWaQWpJBUxR4APYryO8y-eFx8Z35NWPLTa0_cq_hBvrvPiWZomcWGyiqGya50yVSlM1ZoeG--qO4jhb6KFLpIVrvAFjOjUT8WKBESooR1bUrF-z_IoLaJ09QhsA8Fh1Ots7IPF61CIYjhqauaFJgHFWtIPlMKOAvUlsvIxYX2LNInJS9l5ABZTqz75AK0Gkbrpp3FA1NuGExwNecR4JN0bPdz_zZBEpUOxE7hNnABdbloK17x1F5bjyT0HzRjK_GrT6syJLgZV2DdSUKRGULjsN-cKhZgy1Abr22n2b7Wt4MGDSkIsmC6z1M1tkH3m8P0BPP7SB47sjeejsJbTsfEPvJ-6G8AWKFTAigHAcBzWCJYaZMCvAMmvsxFm6AvnofsrHvz19UalNkgeTwW7jWhx1nE3Ei6DRe0DUizSo_hKbnydDwei_gowoxMTm5rD6b3mMJ2phlhg4CPThR_kLdMExDrYtnMbY01kh48UEFCe7Ks2xSq6fV9Nl_3h99EuwVf5atrskJpl2ZoUNwrNDde2JFvt1YJ5wumkPdFPZwVj2sRV5tw0l5IONYCiuHWDlCcBwJ8pIXhyEE3CyPgJtR5apsWhsFh_W00 "DatabaseDiagram")
