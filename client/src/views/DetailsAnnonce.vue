<template>
  <AnnonceComponent :annonce="annonce" :plantes="plantes" />
</template>

<script>
import AnnonceComponent from "../components/AnnonceComponent.vue";
import axios from "axios";

export default {
  name: "DetailsAnnonce",
  components: {
    AnnonceComponent,
  },
  data() {
    return {
      annonce: {},
      plantes: null,
    };
  },
  created: async function () {
    await this.fetchAnnonce();
    await this.fetchPlantes();
  },
  methods: {
    fetchAnnonce: async function () {
      try {
        const response = await axios.get("http://localhost:8080/annonces/" + this.$route.params.id);
        if (response.data !== null || response.data.length) {
          this.annonce = response.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
    fetchPlantes: async function () {
      try {
        const response = await axios.get(this.annonce._links.plantes.href);
        if (response.data._embedded.plantes !== null || response.data._embedded.plantes.length) {
          this.plantes = response.data._embedded.plantes;
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>