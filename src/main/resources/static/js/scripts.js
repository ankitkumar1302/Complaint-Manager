function openModal(element) {
    let imageUrl = element.getAttribute('data-image-url');
    console.log('Image URL:', imageUrl);
    let modal = document.getElementById("imageModal");
    let modalImg = document.getElementById("modalImage");
    modal.style.display = "block";
    modalImg.src = imageUrl;
}

function closeModal() {
    console.log('Closing modal');
    let modal = document.getElementById("imageModal");
    modal.style.display = "none";
}

function toggleDarkMode() {
    document.body.classList.toggle("dark-mode");
}
