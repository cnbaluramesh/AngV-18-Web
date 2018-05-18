function showDeleteAutorizacija(id) {
    $.ajax({
        url: '/autorizacija/show-delete-modal/' + id,
        dataType: 'html',
        type: 'GET',
        success: function (data) {
            $('#deleteAutorizacijaModalContainer').html(data);
            $('#deleteAutorizacijaModal').modal('show');
        }
    });
}

function deleteAutorizacija(id) {
    $.ajax({
        url: '/autorizacija/' + id,
        method: 'DELETE',
        success: function (response) {
            window.location.href = '/autorizacija';
        }
    });
}