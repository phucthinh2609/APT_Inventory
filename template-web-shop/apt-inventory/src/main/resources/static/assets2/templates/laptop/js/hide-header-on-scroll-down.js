var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('.nav-menumobiletablet').outerHeight();

$(window).scroll(function(event) {
    didScroll = true;
});

setInterval(function() {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop();

    // Make sure they scroll more than delta
    if (Math.abs(lastScrollTop - st) <= delta)
        return;

    // If they scrolled down and are past the navbar, add class .nav-up.
    // This is necessary so you never see what is "behind" the navbar.
    if (st > lastScrollTop && st > navbarHeight) {
        // Scroll Down
        $('.nav-menumobiletablet').removeClass('nav-down').addClass('nav-up');
    } else {
        // Scroll Up
        if (st + $(window).height() < $(document).height()) {
            $('.nav-menumobiletablet').removeClass('nav-up').addClass('nav-down');
        }
    }

    lastScrollTop = st;
}

$(window).on('load', function() {
    $(".square-block").fadeOut(), $("#preload-block").fadeOut("slow", function() {
        // a(this).remove()
    })
});

$(document).ready(function() {
    $(document).ajaxStart(function() {
        $("#preload-block").css("display", "block");
        $(".square-block").css("display", "block");
    });
    $(document).ajaxComplete(function() {
        $(".square-block").fadeOut(), $("#preload-block").fadeOut("slow", function() {})

        // load slide image detail product
        $('.show').zoomImage();
        $('.show-small-img:first-of-type').css({
            'border': 'solid 1px #951b25',
            'padding': '2px'
        })
        $('.show-small-img:first-of-type').attr('alt', 'now').siblings().removeAttr('alt')
        $('.show-small-img').click(function() {
            $('#show-img').attr('src', $(this).attr('src'))
            $('#big-img').attr('src', $(this).attr('src'))
            $(this).attr('alt', 'now').siblings().removeAttr('alt')
            $(this).css({
                'border': 'solid 1px #951b25',
                'padding': '2px'
            }).siblings().css({
                'border': 'none',
                'padding': '0'
            })
            if ($('#small-img-roll').children().length > 4) {
                if ($(this).index() >= 3 && $(this).index() < $('#small-img-roll')
                    .children().length - 1) {
                    $('#small-img-roll').css('left', -($(this).index() - 2) * 76 + 'px')
                } else if ($(this).index() == $('#small-img-roll').children().length -
                    1) {
                    $('#small-img-roll').css('left', -($('#small-img-roll').children()
                        .length - 4) * 76 + 'px')
                } else {
                    $('#small-img-roll').css('left', '0')
                }
            }
        })
    });
});

$(".mega-menu-custom").hover(
    function() {
        $(this).children(".drop-menu-main").addClass("show");
    },
    function() {
        $(this).children(".drop-menu-main").removeClass("show");
    }
);

(function() {
    $(document).click(function() {
        var $item = $(".shopping-cart");
        if ($item.hasClass("active")) {
            $item.removeClass("active");
        }
    });

    $('.shopping-cart').each(function() {
        var delay = $(this).index() * 50 + 'ms';
        $(this).css({
            '-webkit-transition-delay': delay,
            '-moz-transition-delay': delay,
            '-o-transition-delay': delay,
            'transition-delay': delay
        });
    });
    $('#cart').click(function(e) {
        e.stopPropagation();
        $(".shopping-cart").toggleClass("active");
    });

    $('#addtocart').click(function(e) {
        e.stopPropagation();
        $(".shopping-cart").toggleClass("active");
    });
})();

$('#addtocart').click(function(e) {
    e.stopPropagation();
    $(".shopping-cart").toggleClass("active");
});

$('.tu_van_mua_hang').click(function(e) {
    e.stopPropagation();
    document.getElementsByClassName('icon-cps-fab-menu')[0].click();
});