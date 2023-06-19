<template>
  <nav class="navbar navbar-expand-lg border-bottom border-2 bg-gradient mb-4">
    <div class="container-fluid navbar-brand mx-4">
      <img
        src="./assets/img/Logo.png"
        width="75"
        height="50"
        id="logo"
        class="d-inline-block align-text-top me-4"
      />
      <div class="navbar">
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </div>
    <div class="collapse navbar-collapse me-4" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <img src="./assets/img/Fleur.png" height="50" id="fleur" alt="fleur" />
        <li class="nav-item">
          <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/creer">Créer</router-link>
        </li>
      </ul>
    </div>
  </nav>
  <router-view />
</template>

<style>
#app {
  font-family: var(--font-family);
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--color-primary);
}

nav {
  background-color: var(--color-primary);
  border-color: var(--color-shade1);
}

.nav-link {
  font-family: var(--font-family);
  font-size: var(--font-size-nav);
  color: var(--color-secondary);
}

.nav-link:hover {
  text-decoration: underline;
}

@media (max-width: 991.98px) {
  #fleur {
    display: none;
  }
  img {
    height: 8vh;
  }
  #logo {
    height: 6vh;
  }
}
</style>
