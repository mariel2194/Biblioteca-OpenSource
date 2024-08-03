$(document).ready(function() {
    $('table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(autor, status) {
            $('#autorId').val(autor.id);
            $('#nombre').val(autor.nombre);
            $('#paisOrigen').val(autor.paisOrigen);
            $('#activo').prop('checked', autor.activo);

            // Cargar el select de idiomas
            $.each($('#idioma option'), function() {
                if ($(this).val() == autor.idioma.id) {
                    $(this).prop('selected', true);
                } else {
                    $(this).prop('selected', false);
                }
            });

            $('#editAutoresModal').modal('show');
        });
    });
});

