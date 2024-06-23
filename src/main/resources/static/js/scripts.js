// static/js/scripts.js
function openModal(element) {
    let imageUrl = element.getAttribute('data-image-url');
    console.log('Image URL:', imageUrl); // This will log the image URL to the console
    let modal = document.getElementById("imageModal");
    let modalImg = document.getElementById("modalImage");
    modal.style.display = "block";
    modalImg.src = imageUrl;
}

function closeModal() {
    console.log('Closing modal'); // Add this line
    var modal = document.getElementById("imageModal");
    modal.style.display = "none";
}

function toggleDarkMode() {
    document.body.classList.toggle("dark-mode");
}
