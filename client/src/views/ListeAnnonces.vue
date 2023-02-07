<template>
  <h1>Liste des annonces</h1>
  <div class="d-flex justify-content-center">
    <div class="row m-2" v-if="!annonces.length">
      <p>Il n'y a aucune annonce de disponible actuellement</p>
    </div>
    <div class="row justify-content-center m-2" v-else>
      <AnnonceCardComponent v-for="a in annonces" :key="a.id" :annonce="a" />
    </div>
  </div>
</template>

<script>
import AnnonceCardComponent from "../components/AnnonceCardComponent.vue";
import axios from "axios";

export default {
  name: "ListeAnnonces",
  components: {
    AnnonceCardComponent,
  },
  data() {
    return {
      annonces: [],
    };
  },
  created() {
    this.fetchAnnonces();
  },
  methods: {
    async fetchAnnonces() {
      try {
        const response = await axios.get("http://localhost:8080/annonces");
        if (response.data._embedded.annonces !== null || !response.data._embedded.annonces.length) {
          this.annonces = response.data._embedded.annonces;
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>
