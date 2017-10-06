from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^herb-info/(?P<herb_name_slug>[\w-]+)/$', views.HerbView.as_view({'get': 'herb_info'})),
    url(r'^search/$', views.HerbView.as_view({'post': 'search_results'})),
]
