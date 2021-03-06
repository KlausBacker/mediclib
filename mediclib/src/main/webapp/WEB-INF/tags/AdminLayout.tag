<%@ attribute name="title" fragment="true" %>

<!DOCTYPE html>
<html>
<head>
    <title><jsp:invoke fragment="title" /></title>

    <meta charset="UTF-8" />
    <base href="/mediclib_war_exploded/" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/style.css" />
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home">MedicLib Admin</a>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="home">Accueil</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="doctor">Medecin</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="medspe">Specialite</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="medcon">Pathologies</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>
        <jsp:invoke fragment="title" />
    </h1>

    LE CONTENU ICI :
    <jsp:doBody />
</div>
</body>
</html>