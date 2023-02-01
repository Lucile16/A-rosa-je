<template>
    <div class="container text-center">
        <h1>Nom de la plante</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                    <img src="https://media.istockphoto.com/photos/young-plant-growing-in-sunlight-picture-id658291850?b=1&k=20&m=658291850&s=612x612&w=0&h=a0XOE6YCZQeeoOesqPfZPVBVRzJLENkjfIoYCSi-a1g="
                        alt="Plante" />
                </div>
                <div class="col">
                    <div>Type de la plante</div>
                    <div>Dimension de la plante</div>
                    <div>Exposition de la plante</div>
                    <div>Arrosage de la plante</div>
                    <div>Famille de la plante</div>
                    <div>Description de la plante</div>
                    <div>{{ plante.nom }}</div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    name: 'PlanteCard',
    props: {
        plante: null
    }
    ,
    data() {
        return {
        }
    }
}

</script>