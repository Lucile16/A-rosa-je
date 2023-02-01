<template>
  <AnnonceItem />
  <a href="#/">Liste des annonces</a> | <a href="#/plantepage{}">Plante</a> |
  <a href="#/non-existent-path">Broken Link</a>
  <component :is="currentView" />
</template>

<script>
import "./assets/css/style.css";
import PlantePage from "./views/PlantePage.vue";
import ListeAnnonces from "./views/ListeAnnonces.vue";

export default {
  name: "App",
  components: {
    PlantePage,
    ListeAnnonces,
  },
};
</script>

<script>
import PlantePage from "./views/PlantePage.vue";
import ListeAnnonces from "./views/ListeAnnonces.vue";

const routes = {
  "/": ListeAnnonces,
  "/about": About,
};

export default {
  data() {
    return {
      currentPath: window.location.hash,
    };
  },
  computed: {
    currentView() {
      return routes[this.currentPath.slice(1) || "/"] || NotFound;
    },
  },
  mounted() {
    window.addEventListener("hashchange", () => {
      this.currentPath = window.location.hash;
    });
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
