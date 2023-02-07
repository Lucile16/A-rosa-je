<template>
  <AnnonceComponent :annonce="annonce" :plants="plants" />
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
      plants: null,
    };
  },
  created: async function () {
    await this.fetchAnnonce();
    await this.fetchPlants();
  },
  methods: {
    fetchAnnonce: async function () {
      try {
        console.log("annonce");
        const response = await axios.get(
          "http://localhost:8080/annonces/" + this.$route.params.id
        );
        console.log(response.data);
        this.annonce = response.data;
        // console.log("ok");
        // console.log(self.commits[0].html_url);
      } catch (error) {
        console.log(error);
      }
    },
    fetchPlants: async function () {
      try {
        console.log("plants");
        const response = await axios.get(this.annonce._links.plantes.href);
        console.log(response.data);
        this.plants = response.data._embedded.plantes;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>
