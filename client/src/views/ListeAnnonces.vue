<template>
  <h1>Liste des annonces</h1>
  <div class="container" v-if="annonces.length">
    <AnnonceCardComponent
      v-for="a in annonces"
      :key="a.id"
      :title="a.title"
      :description="a.description"
    />
  </div>
  <div v-else>Il n'y a aucune annonce.</div>
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
        console.log(response.data._embedded.annonces);
        this.annonces = response.data._embedded.annonces;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
  gap: var(--gap);
}
</style>
