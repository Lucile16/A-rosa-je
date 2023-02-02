<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/plante/1">Plante</router-link> |
    <router-link to="/annonce/1">Annonce</router-link>
    <router-link to="/creer">Creer</router-link>
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
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
