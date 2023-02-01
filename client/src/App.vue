<template>
  <img alt="Vue logo" src="./assets/img/logo.png" />
  <!-- ici on met le composant -->
</template>

<script>
import "./assets/css/style.css";
// import des composants

export default {
  name: "App",
  components: {
    // c'est ici que l'on met le nom du composant importé depuis le script
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--color-primary);
}

body {
  margin: 0;
}
</style>
