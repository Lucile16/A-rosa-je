<template>
    <form>
        <div>
            <label>
                Titre :
                <input v-model="annonce.titre" type="text">
            </label>
            <label>
                Description:
                <textarea v-model="annonce.description"></textarea>
            </label>
        </div>
        <div>
            <label>
                Numéro de rue : <input v-model="annonce.adresse.numero" type="number">
                Rue : <input v-model="annonce.adresse.rue" type="text">
                Code postal : <input v-model="annonce.adresse.codePostal" type="number">
                Ville : <input v-model="annonce.adresse.ville" type="text">
            </label>
        </div>
        <select v-model="selectedPlant">
            <option v-for="plant in plants" :key="plant.id" :value="plant">
            {{ plant.nom }}
            </option>
        </select>
      <button @click.prevent="submitAnnonce">Créer</button>
    </form>
  </template>
  
  <script>
  import axios from "axios";
  export default {
    name: "CreerAnnonce",
    data() {
      return {
        annonce: {
          titre: null,
          description: null,
          adresse: {
            numero: null,
            rue: null,
            codePostal: null,
            ville: null
          }
        },
        plants: [],
        selectedPlant: null
      };
    },
    created() {
        this.fetchPlants();
    },
    methods: {
      async submitAnnonce() {
        try {
          const response = await axios.post('http://localhost:8080/annonces', this.annonce);
          console.log(response.data);
          const response2 = await axios.put(response.data._links.self.href+'/plantes', this.selectedPlant._links.self.href, {
          headers: {
            'Content-Type': 'text/uri-list'
          }
            });
          console.log(response2.data);
        } catch (error) {
          console.error(error);
        }
      },
      async fetchPlants() {
        try {
            const response = await axios.get('http://localhost:8080/plantes');
            console.log(response.data._embedded.plantes);
            this.plants = response.data._embedded.plantes;
        } catch (error) {
            console.error(error);
        }
        }
    }
  };
  </script>