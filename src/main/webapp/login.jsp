<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ingresar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container mb-5">
        <form action="/webapp-cookie/login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Usuario</label>
                <div>
                    <input type="text" name="username" id="username" class="form-control">
                </div>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <div>
                    <input type="password" name="password" id="password" class="form-control">
                </div>
            </div>
            <div>
                <input type="submit" value="Acceso" class="btn btn-primary">
            </div>
        </form>
        <a class="nav-link" href="index.html">Regresar</a>
    </div>

    <script src="https://unpkg.com/@popperjs/core@2" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>