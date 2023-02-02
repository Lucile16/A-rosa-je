<template>
<<<<<<< Updated upstream
  <AnnonceComponent :annonce="annonce" />
=======
  <AnnonceComponent :annonce="annonce" :plants="plants" />
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
      plants: null,
>>>>>>> Stashed changes
    };
  },
  created: function () {
    this.fetchAnnonce();
  },
  methods: {
    fetchAnnonce: async function () {
      try {
<<<<<<< Updated upstream
=======
        console.log("annonce");
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
  },
};
</script>
