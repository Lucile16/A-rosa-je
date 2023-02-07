<template>
  <nav
    class="navbar navbar-expand-lg bg-light border-bottom border-primary border-2 bg-gradient mb-4"
  >
    <div class="container-fluid navbar-brand mx-4">
      <img
        src="./assets/img/logo.svg"
        width="120"
        height="50"
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
        <li class="nav-item">
          <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/creer">Creer</router-link>
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

nav a.nav-link {
  color: var(--color-light);
}

nav a.router-link-active,
nav a.router-link-exact-active {
  color: var(--color-primary);
}
</style>
