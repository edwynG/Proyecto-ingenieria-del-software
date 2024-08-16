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
    "java.project.sourcePaths": [
        "src"
    ],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "./src/lib/sqlite/sqlite-jdbc-3.46.0.1.jar",
        "./src/lib/sqlite/slf4j-api-1.7.36.jar",
    ]
}
```


> #### **IMPORTANTE**
> Asegúrate de tener instalada la extensión **Extension Pack for Java** en Visual Studio Code. De esta forma podrás ejecutar el programa desde el editor.

## Modelo de Dominio
Esta es la  primera versión  del modelo de dominio. En este modelo muestra el **¿Que?** del proyecto desde un **enfoque abstracto**, de manera que muestre de forma sencilla las realciones del diagrama.

![ModeloDeDominio](https://www.plantuml.com/plantuml/png/PLBBRjim4BppAnO-5b20eBUWXwYIZos2rl5zGwwThIcki2JTe6u_gkWdvCSAIl9Blf6pEpFxUem9DUNEmnTnvAMbLZeEB2RkEFIesC5NIVGPxMwhaeDhn8j2KWonHwMGvfcYZlGsIrv-a4tmdI9BE1W0W23TYzBmn9wyPoV3nueg7PyXAKPw_ujW_fYZofDABu52eb6f9zsmRyKMQ40IzzBIqu23cL4pnOGZiw29zwFR9WVB4h1Z2cc2Oj9iKrPiiYhRx5670CMac6ZBkDoZpvXuZsFWZRSKB6CSlYuh5b4uiKQvbXg9IKROgWJPAdPNNTQUqSdXrCyatvFZeSzpvgBUeuSLsS1M5e0HwjMXT3t5qPMbbegTA1mkv_7Sh4S7vSsbOfCr2ZY2vLkY4FdzNnY4c-NDyYmgsaJZN3QY7Kx3EnNTYKFF3jrDod4yvjQxvTvBX-dOKjDEbOyt1F3fTrKfRrzd_PddPWrLDGFF9rDYfoimGHA11F0STl00tmWz_qBJBE73LTvaMZoT_0mN9mZNshc7UcN6tS6nm7frPVHGw2xRQ-xY_kxkVZ4oggegtuyBQ9Rp6YTAgV4yWgOrrrkMgYfWlRgTnKnlFUp6c4SABdV-Fm00 "ModeloDeDominio")

En el siguente diagrama de estados muestra el **proceso de negocios que se quiere automatizar**. En este caso es el proceso para proponer cursos.

![ProcedoDeNegocio](https://www.plantuml.com/plantuml/png/VLBBRjim4BppAnQvwn3x5XXEt5Q708OjE85Flcp8hSrQtYMMbD7sj_e11TeVAoW_Oab1JvHsPsPdXtoA2JKrXneg5KjElj22jcAzcBZt753n00j9z0djVglIiFiijIWaHOu1bJZraQAET8ZQUKT0Xv1-WADerOVaXKrCc0Zku9czzQWGANhXEy08B-td6M65dSyChEzXCh4xyPQcqs5tzD_kUDXj8u39f3slLMANvn2xszAeLrhHriUag71PP4qAyXP9ZsYzCCLsbVNoqY-_1s5I22gXePYmxPVLjN_4ka7h__vYS0GRhh67FPBwhzxYRNop8zQGoBAt0XkM9Bf59or-zdeTNbs4OCDATeS_qPr4gzNLG0nasm4AGTGI9_oMZJY2kh4gPyDpOqx95TFpJO4vdqKnxToNOKa4mb1xtiC3_FbzoSt9e-dSR35zpxHFMuXvpxiTKbOzjZiLEqHuW1TloYfhTxAx_O6kvT7GyinIIEYmOtYKUUlb1qxNIoYQhkYu0ykQpvo8aqHmFWPX_rPJxEYFeT2yQBNwO4GNDroytRjQvLP-pJtVEQhyD8QKsUlo93StPJK_qqVcYTWrX_eV "ProcedoDeNegocio")
## Modelo de Casos de Uso
En este diagrama mostramos el **¿Como?** del proyecto. Este representa los casos de uso mas relevantes.

![UseCase](https://www.plantuml.com/plantuml/png/RP5DRjj038NtSmeYgtQX740mXBYs8NXJ24tgLJRC3ADEFI853XKqA7gWhdk4NApGZrsxxMw6ttipZ-HTDbGRkWIVCsqmaqlqR6026jil1Y4gUOl2BXyZzwZOGO_-Y2tTssiY635oc-X2y56CFg0_jYe3XuqaKJ15pZqgiVsj50sa_whAHgKN9ZOg0JFqvwihrw6B7BCf1b7A4yVBcYlNAMAGcKn7vyvPuMOZWsQ2UqD_lFdk003UxJdwA108CkNuzelVZ-RnB3mhFb4xVQ0JqTDjXZKnAUgKSw1iE8dgPgO7qlWSFIgCACW43xjhAxvW0dlxwJdwML6l7wubNeMbLUpmaSUez9NyuCUqZmolu2NRujpiDilNc690XSX6R997OyozS7nAbESW-wtxCGvewGXMnN2xj5x2QXNPfo5GLRcwWTlgWj0t8mwvgjnXlvrjTLDUEWuxM9tUWckB-xDJA8hJgETrGJ4KnTp5rMQN-lhXF-MwAM5BHjf5HaW8sAiyuJIUyxEJkOINPI7EtH67eKk_0G00 "UseCase")

## Diagrama de Base de datos
Este tipo de diagrama es fundamental para entender cómo se almacenan y acceden a los datos dentro de un sistema de gestión de bases de datos

![DatabaseDiagram](https://www.plantuml.com/plantuml/png/dLJ1Yjj03BtxAmQVsaC2kUQqIoOBfbqsP7SFEIgs6XHiAMWqeL3wKVs6_bYnrqupZjD3JyPw3-b9Jvg7OA0MczfvCDX3G4zmK6YoJFP7BCrjL4x2o8RXH-QSkmeKVabixjFco-SEMOagoj85K-937s9J2FZx5omTiNN1Dpg9nmrg48OB_UUbv6FL45CmXKfqA9i42zzb-z_IIQu90LxAs22R18zRFBHCwMLCGeLtwIII6NqeVUgXRV6Ko2nUlsvJtL6LobZ79Wc_aSLQtfdEg84CbD9s1p7Fg2MmKNtTL-9cn61mPMRtF_Ro7nrCpl3rhnAFB0qnb2ISI7pP7z7eB67t5Bc2Teotf0tgDwez5dnG3B9RTvyfYfIjl0HP1zDOMbGOfWYw4Lr9Sq93BWd23HyC3mJ1u_eCTUm4xNpKMsNhxtJuoB7cPp1KWXh3Bg2UgIG9TvHuN4cm4RnIOMdl33okZrZ6jjeZHwWJsZjJ1TKMmqaumBx6YMNTOeYrGILXREu5kNRPtTYS8eFBq_Sse2_xjkrkHXX6UzWNJVPlkEoQMg7zHNS_avBkRDvzjIjGWtPf36zywx5s2LGQ2gcoR6f-Bb_airc-oAyEvXvnFcVdN3xJsSpbRk7oyVkLJRuPNObugT4_iTbDwZPnxaQiVevtSepH-PoJHh87v2eszHy0 "DatabaseDiagram")