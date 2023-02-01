<template>
    <div class="annonce_item">
        <h1>Titre</h1>
        <div class="d-flex justify-content-center mb-5">
            <div class="card" style="max-width: 540px; border-color: white;">
                <div class="row g-4">
                    <div class="col-md-6">
                        <img src="../assets/logo.png" class="img-fluid rounded-start" alt="image_plante_annonce">
                    </div>
                    <div class="col-md-6">
                        <div class="card-body">
                            <h5 class="card-title">Description :</h5>
                            <p class="card-text">desc</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <h3>Liste des plantes</h3>
        <div class="d-flex justify-content-evenly">
            <img src="../assets/logo.png" alt="image_plante">
            <img src="../assets/logo.png" alt="image_plante">
            <img src="../assets/logo.png" alt="image_plante">
        </div>

        <p class="mt-5"><small class="text-muted">Etat et createur : créé par créateur</small></p>
    </div>
</template>
  
<script>
// import PlanteItem from "@/components/PlanteItem.vue";
// import axios from 'axios';

export default {
    name: "AnnonceItem",
    // components: {
    //     PlanteItem
    // },
    // data() {
    //     return {
    //         plantes: [],
    //     }
    // },
    props: {
        titre: String,
        image: String,
        description: String,
        // plante: Plante,
        etat: String,
        createur: String
    },
    // created: async function () {
    //     await this.getPlantes()
    // },
 
    // methods: {
    //     getPlantes: async function () {
    //     return await axios
    //         .get('https://dummyjson.com/plantes')
    //         .then((res) => {
    //             console.log(res.data)
    //             this.plantes = res.data
    //         })
    //     }
    // }
};
</script>