<template>
  <h1 class="text-center" style="color: var(--color-primary-dark);">Création d'une annonce</h1>
  <div v-if="!data.length">
    <div class="d-flex flex-column align-items-center">
      <!-- Trouver comment revenir sur la page de création d'une annonce sans avoir à réactualiser la page -->
      <form class="row g-3 justify-content-center container text-center mt-2" v-on:submit.prevent="submitAnnonce" action="http://localhost:8081/#/creer" method="POST">
        <div class="col-md-10">
          <div class="input-group has-validation">
            <span class="input-group-text">Nom de l'annonce</span>
            <input type="text" class="form-control" v-model="annonce.titre" maxlength="90" required>
          </div>
        </div>

        <div class="mt-5 col-md-10">
          <div class="has-validation">
            <span class="input-group-text">Description</span>
            <textarea class="form-control" v-model="annonce.description" rows="8" required></textarea>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3">
          <div class="input-group has-validation">
            <span class="input-group-text">Numéro de rue</span>
            <input type="number" class="form-control" v-model="annonce.adresse.numero" required>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7">
          <div class="input-group has-validation">
            <span class="input-group-text">Rue/Voie</span>
            <input type="text" class="form-control" v-model="annonce.adresse.rue" maxlength="90" required>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3">
          <div class="input-group has-validation">
            <span class="input-group-text">Code postal</span>
            <input type="number" class="form-control" v-model="annonce.adresse.codePostal" required>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7">
          <div class="input-group has-validation">
            <span class="input-group-text">Ville</span>
            <input type="text" class="form-control" v-model="annonce.adresse.ville" maxlength="90" required>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-5">
          <span class="input-group-text">Plante</span>
          <select class="form-select" v-model="selectedPlant" required>
            <option selected disabled value="">Choisissez une plante...</option>
            <option v-for="plant in plants" :key="plant.id" :value="plant">{{ plant.nom }}</option>
          </select>
          <div class="invalid-feedback">Veuillez sélectionner un niveau</div>
        </div>

        <div class="mt-5">
            <button class="btn btn-success me-5" type="submit">Valider</button> <!--@click.prevent="submitAnnonce"-->
            <button class="btn btn-danger" type="reset">Annuler</button>
        </div>
      </form>
    </div>
  </div>
  <div v-else>
    <div class="alert alert-success alert-dismissible fade show w-50 mt-4 d-inline-flex" role="alert">
      <div>
        Vous venez de créer une annonce !
      </div>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <div class="card" style="border-color: var(--color-background);background-color: var(--color-background);">
      <div class="card-body">
        <h4 class="card-title">Rappel des informations</h4>
        <p class="mt-4 card-text fw-normal"><b>Titre de l'annonce :</b> {{annonce.titre}}</p>
        <p class="mt-4 card-text fw-normal"><b>Description de l'annonce :</b> {{annonce.description}}</p>
        <p class="mt-4 card-text fw-normal"><b>Adresse :</b> {{annonce.adresse.numero}} {{annonce.adresse.rue}} {{annonce.adresse.codePostal}} {{annonce.adresse.ville}}</p>
        <p class="mt-4 card-text fw-normal"><b>Plante :</b> {{selectedPlant.nom}}</p>
      </div>
    </div>
  </div>

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
        selectedPlant: null,
        data : []
      };
    },
    created() {
      this.fetchPlants();
    },
    methods: {
      async submitAnnonce() {
        try {
          const response = await axios.post('http://localhost:8080/annonces', this.annonce);
          if (this.selectedPlant !== null) {
            await axios.put(response.data._links.self.href+'/plantes', this.selectedPlant._links.self.href, {
              headers: {
                'Content-Type': 'text/uri-list'
              }
            });
          }
          this.data.push(response.data);
        } catch (error) {
          console.error(error);
        }

        form.classList.add("was-validated");
      },
      async fetchPlants() {
        try {
            const response = await axios.get('http://localhost:8080/plantes');
            if (response.data._embedded.plantes !== null || !response.data._embedded.plantes.length) {
              this.plants = response.data._embedded.plantes;
            }
        } catch (error) {
            console.error(error);
        }
        }
    }
  };

  //Fonction Bootstrap qui vérifie si les champs sont valides
    (function () {
  //Le mode strict lève des exceptions si erreur et exécute le code plus rapidement
  'use strict'
  var forms = document.querySelectorAll('.needs-validation')

  //Permet de convertir des objets/collections similaires à des tableaux, en un nouveau tableau
  Array.prototype.slice.call(forms)
      .forEach(function (form) {
      form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }

          form.classList.add('was-validated')
      }, false)
      })
  })();
</script>
